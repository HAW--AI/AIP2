package aip2.m.RechnungsModul;

import java.util.Date;

/**
 * Read only Sicht auf einen Zahlungseingang
 * 
 */
public interface IZahlungseingang {

	/**
	 * Liefet die Nr
	 * 
	 * @return nr
	 */
	int getZahlungseingangNr();

	/**
	 * Liefet das Zahlungseingangsdatum
	 * 
	 * @return date
	 */
	Date getEingangsDatum();

	/**
	 * Liefert die Höhe der EInzahlung in Cent
	 * 
	 * @return cents
	 */
	int getBetragCent();

	/**
	 * Liefert die der Zahlung zugehörige Lieferung
	 * 
	 * @return null falls noch keine Zuordnung besteht, sonst die Rechnung
	 */
	IRechnung getRechnung();

}