package aip2.m.RechnungsModul;

import java.util.Date;
import java.util.Set;

import aip2.m.AngebotAuftragModul.IAuftrag;

/**
 * Read only Sicht auf eine Rechnung
 * 
 */
public interface IRechnung {

	/**
	 * Liefert die RechnungsNr
	 * 
	 * @return RechnungsNr
	 */
	int getRechnungsNr();

	/**
	 * Liefert das Rechnungsdatum
	 * 
	 * @return ein Datum
	 */
	Date getRechnungsDatum();

	/**
	 * Sagt ob die Rechnung bereits bezahlt wurde
	 * 
	 * @return w f
	 */
	boolean isIstBezahlt();

	/**
	 * Liefert den Betrag der Rechnug in Cent
	 * 
	 * @return preis in Cent
	 */
	int getPreis();

	/**
	 * Liefert den der Rechnung zugehörigen Auftrag
	 * 
	 * @return der Auftrag
	 */
	IAuftrag getAuftrag();

	/**
	 * Liefert die der Rechnung zugeordneten Zahlungseingänge
	 * 
	 * @return leeres Set bei keinen verbuchten, sonst die verbuchten
	 */
	Set<Zahlungseingang> getZahlungseingaenge();

}