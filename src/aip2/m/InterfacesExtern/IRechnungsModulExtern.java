package aip2.m.InterfacesExtern;

import java.util.Date;
/**
 * Stellt Methoden des RechnungsModul für externe Benutzer bereit
 * 
 */
public interface IRechnungsModulExtern {
	
	/**
	 * Verbucht einen Zahlungseingang
	 * @param datum
	 * @param betragCent
	 * @return w f t
	 */
	boolean erzeugeZahlungsEingang(Date datum, int betragCent);

}
