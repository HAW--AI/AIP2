package aip2.m.InterfacesExtern;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import aip2.m.RechnungsModul.RechnungTyp;

/**
 * Stellt Methoden des RechnungsModul für externe Benutzer bereit
 * 
 */
public interface IRechnungsModulExtern extends Remote {

	/**
	 * Erzeugt einen Zahlungseingang
	 * 
	 * @param datum
	 * @param betragCent
	 * @return w f t
	 */
	boolean erzeugeZahlungsEingang(Date datum, int betragCent) throws RemoteException;

	/**
	 * Erzeugt einen Zahlungseingang und verbucht ihn für Rechnung mit nr
	 * 
	 * @param rechnungsNr
	 * @param datum
	 * @param betragCent
	 * @return w f t
	 */
	boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr, Date datum,
			int betragCent) throws RemoteException;

	/**
	 * Sucht alle bezahlten Rechnungen
	 * 
	 * @return eine leere Liste, oder alle jemals bezahlten Rechnungen
	 */
	List<RechnungTyp> sucheBezahlteRechnungen() throws RemoteException;
}
