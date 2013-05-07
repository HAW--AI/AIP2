package aip2.m.AngebotAuftragModul;

import java.util.Date;

import aip2.m.LieferungsModul.ILieferung;
import aip2.m.RechnungsModul.IRechnung;

/**
 * Read only Sicht auf einen Auftrag
 * 
 */
public interface IAuftrag {

	/**
	 * Gibt die AuftragsNr zurück
	 * 
	 * @return AuftragsNr
	 */
	int getAuftragsNr();

	/**
	 * Ist der Auftrag schon erledigt?
	 * 
	 * @return true oder false
	 */
	boolean isAbgeschlossen();

	/**
	 * Gibt das Datum zurück an dem der Auftrag Beauftrag wurde
	 * 
	 * @return Datum
	 */
	Date getBeauftragtAm();

	/**
	 * Gibt das zum Auftrag gehörende Angebot zurück
	 * 
	 * @return das ursprüngliche Angebot
	 */
	IAngebot getAngebot();

	/**
	 * Gibt die zum Auftrag gehörende Lieferung zurück
	 * 
	 * @return null falls noch keine Lieferung veranlasst wurde, sonst die
	 *         Lieferung
	 */
	ILieferung getLieferung();

	/**
	 * Gibr die zugehörige Rechnung zurück
	 * 
	 * @return null falls noch keine Rechnung erstellet wurde, sonst die
	 *         Rechnung
	 */
	IRechnung getRechnung();

}