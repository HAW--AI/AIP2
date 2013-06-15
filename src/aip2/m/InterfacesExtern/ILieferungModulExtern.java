package aip2.m.InterfacesExtern;

//import java.util.List;

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
	
	/**
	 * Liefert eine Liste der Ids von unbestätigten Lieferungen
	 * 
	 * @return Liste der Ids
	 */
	//List<Integer> sucheUnbestaetigeLieferungen();
}
