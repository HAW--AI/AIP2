package aip2.redundanz;

import java.rmi.Remote;
import java.rmi.RemoteException;

import aip2.m.IHES_System;

public interface IMonitorRR extends Remote{
	public static final int PORT = 1099;
	public static final String NAME = "HES RR";

	/**
	 * Gibt das nach RR nächste HES.
	 * 
	 * @pre es gibt Lauffähige HES!
	 */
	IHES_System getCurrentHES() throws RemoteException;

}
