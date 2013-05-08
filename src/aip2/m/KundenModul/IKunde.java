package aip2.m.KundenModul;

/**
 * Read only Sicht auf einen Kunden
 * 
 */
public interface IKunde {

	/**
	 * Gibt eine eindeutige Kundennmmer zurück
	 * 
	 * @return die Kundennummer
	 */
	int getKundenNr();

	/**
	 * Gibt den Namen des Kunden zurück
	 * 
	 * @return der Kundenname
	 */
	String getName();

	/**
	 * Gibt die Adresse des Kunden zurück
	 * 
	 * @return die Kundenadresse
	 */
	String getAdresse();

//	/**
//	 * Gibt die dem Kunden gemachten Angebote zurück
//	 * 
//	 * @return Eine Menge der Angebote des Kunden
//	 */
//	Set<IAngebot> getAngebote();

}