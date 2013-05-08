package aip2.m.InterfacesExtern;

import java.util.Date;

/**
 * Stellt Methoden des RechnungsModul für externe Benutzer bereit
 * 
 */
public interface IRechnungsModulExtern {

	/**
	 * Erzeugt einen Zahlungseingang
	 * 
	 * @param datum
	 * @param betragCent
	 * @return w f t
	 */
	boolean erzeugeZahlungsEingang(Date datum, int betragCent);

	/**
	 * Erzeugt einen Zahlungseingang und verbucht ihn für Rechnung mit nr
	 * 
	 * @param rechnungsNr
	 * @param datum
	 * @param betragCent
	 * @return w f t
	 */
	boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr, Date datum,
			int betragCent);

}
