package aip2.m.InterfacesExtern;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHES_System extends Remote {

	public IAngebotAuftragModulExtern getIAngebotAuftragModulExtern() throws RemoteException;

	public IKundenModulExtern getIKundenModulExtern() throws RemoteException;

	public ILieferungModulExtern getILieferungModulExtern() throws RemoteException;

	public IProduktModulExtern getIProduktModulExtern() throws RemoteException;

	public IRechnungsModulExtern getIRechnungsModulExtern() throws RemoteException;
}
