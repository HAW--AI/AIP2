package aip2.m.InterfacesExtern;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Stellt Methoden zum LieferungsModul für externe Benutzer bereit
 * 
 */
public interface ILieferungModulExtern extends Remote {
	/**
	 * Bestätigt, dass die Lieferung angekommen ist
	 * 
	 * @param lieferungsNummer
	 * @return erfolg der operation
	 */
	boolean bestaetigeLieferung(int lieferungsNummer) throws RemoteException;
}
