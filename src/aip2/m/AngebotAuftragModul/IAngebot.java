package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.Map;

import aip2.m.KundenModul.IKunde;
import aip2.m.ProduktModul.IProdukt;

/**
 * Read only Sicht auf einen Angebot
 * 
 */
public interface IAngebot {

	/**
	 * Gibt die AngebotsNr zurück
	 * 
	 * @return AngebotsNr
	 */
	int getAngebotsNr();

	/**
	 * Gibt das Datum von dem das Angebot gültig ist zurück
	 * 
	 * @return GültigAbDatum
	 */
	Date getGueltigAb();

	/**
	 * * Gibt das Datum bis zu dem das Angebot gültig ist zurück
	 * 
	 * @return AngebotAblaufDatum
	 */
	Date getGueltigBis();

	/**
	 * Gibt den GesamtPreis in Cent zurück
	 * 
	 * @return der Preis in Cent
	 */
	int getGesamtpreis();

	/**
	 * Gibt falls vorhanden den zugehörigen Auftrag zurück
	 * 
	 * @return null falls kein Auftrag vorliegt, sonst der Auftrag
	 */
	IAuftrag getAuftrag();

	/**
	 * Gibt den Kunden dem das Angebot gemacht wurder zurück
	 * 
	 * @return Kunde
	 */
	IKunde getKunde();

	/**
	 * Gibt die Map die die angeforderten Produkte auf die angeforderte Menge
	 * abbildet zurück
	 * 
	 * @return ProduktAnzahlMap
	 */
	Map<IProdukt, Integer>/* List<IProduktMenge> */getProdukte();

}