package aip2.m.LieferungsModul;

import java.util.Date;

/**
 * Read only Sicht auf einen Transportauftrag
 * 
 */
public interface ITransportauftrag {

	/**
	 * Gibt die TransportNr
	 * 
	 * @return TransportNr
	 */
	int getTransportAuftragNr();

	/**
	 * Gibt die zugehöroge Lieferung
	 * 
	 * @return null, falls noch keiner lieferung zugeordnet
	 */
	ILieferung getLieferung();

	/**
	 * Gibt das Ausgangdatum an
	 * 
	 * @return Date
	 */
	Date getAusgangsDatum();

	/**
	 * Sagt ob die LIeferung bereits erfolgt ist
	 * 
	 * @return wf
	 */
	boolean isLieferungErfolgt();

	/**
	 * Gibt das ablieferDatum
	 * 
	 * @return null, falls noch nicht geliefert sonst Datum
	 */
	Date getLieferDatum();

	/**
	 * Gibt den Transportdiensleister
	 * 
	 * @return Transportdiensleister
	 */
	String getTransportDienstleister();
}