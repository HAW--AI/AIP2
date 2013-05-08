package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.ProduktModul.IProdukt;

/**
 * Verwalter Kunden: erstellt, sucheNachNamen und erzeugt den Fachlichen
 * Datentyp KundenTyp
 * 
 */
final class WarenmeldungsVerwalter {

	private final IPersistenzIntern persistenzManager;

	WarenmeldungsVerwalter(IPersistenzIntern pm) {
		this.persistenzManager = pm;
	}

	Wareneingangsmeldung erstelleWareneingangsmeldung(Date datum, int menge, String lieferschein, IBestellung bestellung) {
		Wareneingangsmeldung w = new Wareneingangsmeldung(datum, menge, lieferschein, bestellung);

		persistenzManager.add(w);

		return w;
	}

	IWarenausgangsmeldung erstelleWarenausgangsmeldung(Date datum, int menge, IProdukt produkt) {
		IWarenausgangsmeldung m = new Warenausgangsmeldung(datum, menge, produkt);
		persistenzManager.add(m);
		return m;
	}

//	List<Wareneingangsmeldung> sucheWareneingangsmeldungen(IBestellung bestellung) {
//		return persistenzManager.getFromWhere(Wareneingangsmeldung.class, "bestellung_id", bestellung.getBestellNr());
//	}
//
//	Wareneingangsmeldung getWareneingangsmeldungById(int nr) {
//		return persistenzManager.getById(Wareneingangsmeldung.class, nr);
//	}

}
