package aip2.redundanz;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import aip2.m.InterfacesExtern.IHES_System;

public class DispatcherMonitor implements IDispatcherMonitor {
	Map<IHES_System, SystemData> systeme = new HashMap<IHES_System, SystemData>(); 
	
	DispatcherMonitor() throws RemoteException {
		IDispatcherMonitor stub = (IDispatcherMonitor) UnicastRemoteObject.exportObject(this, 0);
		java.rmi.registry.LocateRegistry.createRegistry(PORT);
	    Registry registry = LocateRegistry.getRegistry();
	    
	    try {
			registry.bind(NAME, stub);
		} catch (AlreadyBoundException e) {
			System.err.println("Dispatcher already running!");
			System.exit(-1);
		}
	}
	
	@Override
	public boolean registerAtDispatcher(IHES_System system, String hostname) throws RemoteException {
		if (systeme.containsKey(system)) return false;
		
		systeme.put(system, new SystemData(hostname));
		return true;
	}

	@Override
	public void iAmAlive(IHES_System system) throws RemoteException {
		if (!systeme.containsKey(system)) {
			System.err.println("IAmAlive von unbekanntem System...");
		}
		
		SystemData d = systeme.get(system);
		long last = d.getLastAlive();
		
		d.setLastAlive(System.currentTimeMillis());
		d.setMillisecondsUp(d.getMillisecondsUp() + (System.currentTimeMillis() - last));
		
		System.out.println("IAmAlive von "+d.getHostname());
	}

	public static void main(String[] args) throws RemoteException {
		new DispatcherMonitor();
		while(true) {}
	}
}
