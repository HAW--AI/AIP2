package aip2.redundanz;

import java.rmi.Remote;
import java.rmi.RemoteException;

import aip2.m.InterfacesExtern.IHES_System;

public interface IDispatcherMonitor extends Remote {
	public static final int PORT = 1099;
	public static final String NAME = "HES Dispatcher";
	
	/**
	 * Registriert ein HES System an den Dispatcher/Monitor.
	 * @pre Null nicht erlaubt!
	 */
	public boolean registerAtDispatcher(IHES_System system, String hostname) throws RemoteException;

	/**
	 * Sendet ein "IAmAlive" an den Monitor.
	 * @pre Null nicht erlaubt!
	 */
	public void iAmAlive(IHES_System system) throws RemoteException;
}
