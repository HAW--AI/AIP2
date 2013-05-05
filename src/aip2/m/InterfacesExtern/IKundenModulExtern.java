package aip2.m.InterfacesExtern;

import java.util.List;

import aip2.m.KundenModul.IKunde;
import aip2.m.KundenModul.KundenTyp;

/**
 * Stellt Methoden zum Kunden für externe Benutzer bereit
 *
 */
public interface IKundenModulExtern {

	/**
	 * Sucht Kunden mit gegebenem Namen
	 * 
	 * @param name
	 *            Der gesuchte Name eines Kunden
	 * @return Eine Liste von Kunden mit gesuchtem Namen oder eine leere Liste
	 *         falls es keinen Kunden mit entsprechendem Namen gibt
	 */
	List<KundenTyp> sucheKunden(String name);
	
	/**
	 * Sucht Kunden mit gegebener Id
	 * 
	 * @param kundenId
	 *            Die Id des Kunden
	 * @return Der gewünschte Kunde oder null
	 */
	KundenTyp sucheKunden(int kundenId);
	
	/**
	 * Erstellt einen neuen Kunden
	 * @param name
	 * @param adresse
	 * @return den erstellten Kunden
	 */
	IKunde erstelleKunde(String name, String adresse);
	
}
