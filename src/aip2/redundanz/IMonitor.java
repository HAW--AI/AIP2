package aip2.redundanz;

import java.rmi.Remote;
import java.rmi.RemoteException;

import aip2.m.InterfacesExtern.IHES_System;

public interface IMonitor extends Remote {
	public static final int PORT = 1099;
	public static final String NAME = "HES Monitor";
	
	/**
	 * Registriert ein HES System an den Monitor.
	 * @pre Null nicht erlaubt!
	 */
	public boolean registerAtMonitor(IHES_System system, String hostname) throws RemoteException;

	/**
	 * Sendet ein "IAmAlive" an den Monitor.
	 * @pre Null nicht erlaubt!
	 */
	public void iAmAlive(IHES_System system) throws RemoteException;
}
