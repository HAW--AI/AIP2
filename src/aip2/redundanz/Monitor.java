package aip2.redundanz;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import aip2.m.InterfacesExtern.IHES_System;

public class Monitor implements IMonitor, IMonitorGUI {
	private static final int ALIVE_MILLISECONDS = 10000;	
	private static final int ALIVECHECK_MILLISECONDS = 20000;	
	private static int curNumber = 0;
	
	Map<IHES_System, SystemData> aliveSystems = new HashMap<IHES_System, SystemData>(); 
	Map<IHES_System, SystemData> deadSystems = new HashMap<IHES_System, SystemData>(); 
	
	IHES_System currentSystem = null;
	
	Monitor() throws RemoteException {
		IMonitor stub = (IMonitor) UnicastRemoteObject.exportObject(this, 0);
		java.rmi.registry.LocateRegistry.createRegistry(PORT);
	    Registry registry = LocateRegistry.getRegistry();
	    
	    try {
			registry.bind(NAME, stub);
		} catch (AlreadyBoundException e) {
			System.err.println("Monitor already running!");
			System.exit(-1);
		}
	}
	
	IHES_System getCurrentHES() {		
//		if (currentSystem == null) {
//			currentSystem = aliveSystems.firstKey();
//		}
//		else {
//			SortedMap<IHES_System, SystemData> sub = aliveSystems.tailMap(currentSystem);
//			if (sub.size() == 0) currentSystem = aliveSystems.firstKey();
//			else currentSystem = sub.firstKey();
//		}
		
		return aliveSystems.keySet().iterator().next();
	}
	
	@Override
	public boolean registerAtMonitor(IHES_System system, String hostname) throws RemoteException {
		if (aliveSystems.containsKey(system)) return false;
		
		if (deadSystems.containsKey(system)) {
			SystemData d = deadSystems.get(system);
			d.setAlive(true);
			
			deadSystems.remove(system);
			aliveSystems.put(system, d);
		}
		else {
			aliveSystems.put(system, new SystemData(hostname, curNumber++));
		}
		
		return true;
	}

	@Override
	public void iAmAlive(IHES_System system) throws RemoteException {
		if (aliveSystems.containsKey(system)) {
			SystemData d = aliveSystems.get(system);
			long last = d.getLastAlive();
			
			d.setLastAlive(System.currentTimeMillis());
			d.setMillisecondsUp(d.getMillisecondsUp() + (System.currentTimeMillis() - last));
			
			System.out.println("IAmAlive von "+d.getHostname());
		}
		else if (deadSystems.containsKey(system)) {
			SystemData d = deadSystems.get(system);
			d.setAlive(true);
			d.setLastAlive(System.currentTimeMillis());
			
			deadSystems.remove(system);
			aliveSystems.put(system, d);			
		}
		else {
			System.err.println("IAmAlive von Unbekannt...");
		}
	}
	
	void run() {
		while(true) {
			for (IHES_System sys : aliveSystems.keySet()) {
				SystemData d = aliveSystems.get(sys);
				
				if (System.currentTimeMillis() - d.getLastAlive() > ALIVE_MILLISECONDS) {
					// dead
					d.setAlive(false);
					aliveSystems.remove(sys);
					deadSystems.put(sys, d);
				}
			}
			
			try { Thread.sleep(ALIVECHECK_MILLISECONDS); } catch (InterruptedException e) {}
		}
	}

	@Override
	public List<SystemData> getAllSystems() {
		List<SystemData> list = new ArrayList<SystemData>();
		for (SystemData s : aliveSystems.values()) list.add(s);
		for (SystemData s : deadSystems.values()) list.add(s);	
		return list;
	}

	@Override
	public void setSystemAlive(int number, boolean value) {
		IHES_System sys = null;
		
		for (IHES_System s : aliveSystems.keySet()) {
			SystemData d = aliveSystems.get(s);
			if (d.getNumber() == number) {
				sys = s;
				d.setAlive(value);
				
				if (!value) {
					aliveSystems.remove(s);
					deadSystems.put(sys, d);
				}
			}
		}
		
		for (IHES_System s : deadSystems.keySet()) {
			SystemData d = deadSystems.get(s);
			if (d.getNumber() == number) {
				sys = s;
				d.setAlive(value);
				
				if (value) {
					deadSystems.remove(s);
					aliveSystems.put(sys, d);
				}
			}
		}
	}
}
