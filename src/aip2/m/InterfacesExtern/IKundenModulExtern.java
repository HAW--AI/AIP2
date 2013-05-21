package aip2.m.InterfacesExtern;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import aip2.m.KundenModul.KundenTyp;

/**
 * Stellt Methoden zum Kunden für externe Benutzer bereit
 *
 */
public interface IKundenModulExtern extends Remote {

	/**
	 * Sucht Kunden mit gegebenem Namen
	 * 
	 * @param name
	 *            Der gesuchte Name eines Kunden
	 * @return Eine Liste von Kunden mit gesuchtem Namen oder eine leere Liste
	 *         falls es keinen Kunden mit entsprechendem Namen gibt
	 */
	List<KundenTyp> sucheKunden(String name) throws RemoteException;
	
	/**
	 * Sucht Kunden mit gegebener Id
	 * 
	 * @param kundenId
	 *            Die Id des Kunden
	 * @return Der gewünschte Kunde oder null
	 */
	KundenTyp sucheKunden(int kundenId) throws RemoteException;
	
	/**
	 * Erstellt einen neuen Kunden
	 * @param name
	 * @param adresse
	 * @return den erstellten Kunden oder null bei Misserfolg
	 */
	KundenTyp erstelleKunde(String name, String adresse) throws RemoteException;
	
}
