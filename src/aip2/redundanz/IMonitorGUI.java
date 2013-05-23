package aip2.redundanz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IMonitorGUI extends Remote {	
	public List<SystemData> getAllSystems() throws RemoteException;
	
	public void toggleSystemAlive(String name) throws RemoteException;
}
