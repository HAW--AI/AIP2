package aip2.m.InterfacesExtern;

/**
 * Stellt Methoden zum LieferungsModul für externe Benutzer bereit
 * 
 */
public interface ILieferungModulExtern {
	/**
	 * Bestätigt, dass die Lieferung angekommen ist
	 * 
	 * @param lieferungsNummer
	 * @return erfolg der operation
	 */
	boolean bestaetigeLieferung(int lieferungsNummer);
}
