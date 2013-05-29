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

import aip2.m.IHES_System;

public class Monitor extends UnicastRemoteObject implements IMonitorRR, IMonitor, IMonitorGUI {
	private static final long serialVersionUID = 1L;
	private static final int ALIVE_MILLISECONDS = 5000;	
	private static final int ALIVECHECK_MILLISECONDS = 2500;	
	private static final boolean DEBUG = false;	

	Map<String, IHES_System> systems = new HashMap<String, IHES_System>(); 
	Map<String, SystemData> systemsData = new HashMap<String, SystemData>(); 
	
	Monitor() throws RemoteException {	
		java.rmi.registry.LocateRegistry.createRegistry(IMonitor.PORT);
	    Registry registry = LocateRegistry.getRegistry();
	    	    
	    try {
			registry.bind(IMonitor.NAME, this);			
		} catch (AlreadyBoundException e) {
			System.err.println("Monitor already running!");
			System.exit(-1);
		}
	    
	    try {
			registry.bind(IMonitorRR.NAME, this);			
		} catch (AlreadyBoundException e) {
			System.err.println("Monitor already running!");
			System.exit(-1);
		}
	    
		System.out.println("Monitor is running...");

	}
	
	@Override
	public IHES_System getCurrentHES() {		
		String curSys = null;
		long curTime = System.currentTimeMillis();
		
		for (String s : systemsData.keySet()) {
			SystemData d = systemsData.get(s);
			
			if (d.isAlive() && d.isEnabled() && d.getLastRequest() < curTime) {
				curSys = s;
				curTime = d.getLastRequest();
			}
		}
		
		if (curSys == null) throw new RuntimeException("All HES Systems are down!");
		System.out.println("Current HES: "+systemsData.get(curSys).getName());
		
		systemsData.get(curSys).incRequestCounter();
		systemsData.get(curSys).setLastRequest(System.currentTimeMillis());
		return systems.get(curSys);
	}
	
	@Override
	public boolean registerAtMonitor(IHES_System system, String name, String hostname) throws RemoteException {
		if (systems.containsKey(name)) {			
			SystemData d = systemsData.get(name);
			
			// already active?
			if (d.isAlive()) return false;	
			
			// update ref and values
			systems.put(name, system);
			d.setAlive(true);
			d.addDownTime(System.currentTimeMillis() - d.getLastAlive());
			d.setStartTime(System.currentTimeMillis());
			d.setLastAlive(System.currentTimeMillis());
			d.setHostname(hostname);
			System.out.println(name+" REregistered @ "+hostname+"!");
		}
		else {
			systems.put(name, system);
			systemsData.put(name, new SystemData(name, hostname));
			System.out.println(name+" registered @ "+hostname+"!");
		}
		
		return true;
	}

	@Override
	public void iAmAlive(String name) throws RemoteException {
		if (systems.containsKey(name)) {
			SystemData d = systemsData.get(name);
			long last = d.getLastAlive();			
			d.setLastAlive(System.currentTimeMillis());
			
			if (d.isAlive()) d.addUpTime(System.currentTimeMillis() - last);
			else d.setAlive(true);
			
			if(DEBUG)
				System.out.println("IAmAlive von "+name);
		}
		else {
			System.err.println("IAmAlive von Unbekannt ["+name+"]");
		}
	}
	
	void run() {
		while(true) {
			for (String s : systems.keySet()) {
				SystemData d = systemsData.get(s);
				
				if (d.isAlive() && System.currentTimeMillis() - d.getLastAlive() > ALIVE_MILLISECONDS) {
					// dead
					d.setAlive(false);
					System.out.println(d.getName()+" timeout nach "+ALIVE_MILLISECONDS+"ms!");
				}
			}
			
			try { Thread.sleep(ALIVECHECK_MILLISECONDS); } catch (InterruptedException e) {}
		}
	}

	@Override
	public List<SystemData> getAllSystems() throws RemoteException {
		return new ArrayList<SystemData>(systemsData.values());
	}

	@Override
	public void toggleSystemAlive(String name) throws RemoteException {
		SystemData d = systemsData.get(name);
		d.setEnabled(!d.isEnabled());
	}
	
	public static void main(String[] args)throws Exception{
		(new Monitor()).run();
	}
}
