package aip2.m.WarenmeldungsModul;

import java.util.Date;
import java.util.List;

import aip2.m.BestellungsModul.IBestellung;
import aip2.m.PersistenzModul.IPersistenzIntern;

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

	List<Wareneingangsmeldung> sucheWareneingangsmeldungen(IBestellung bestellung) {
		return persistenzManager.getFromWhere(Wareneingangsmeldung.class, "bestellung_id", bestellung.getBestellNr());
	}

	WareneingangsmeldungTyp getWareneingangsmeldungTyp(IWareneingangsmeldung wareneingangsmeldung) {
		WareneingangsmeldungTyp wareneingangsmeldungTyp = new WareneingangsmeldungTyp(wareneingangsmeldung.getWareneingangsmeldungNr(),
				wareneingangsmeldung.getDatum(), wareneingangsmeldung.getMenge(),
				wareneingangsmeldung.getLieferschein(), wareneingangsmeldung.getBestellung());
		return wareneingangsmeldungTyp;
	}

	Wareneingangsmeldung getWareneingangsmeldungById(int nr) {
		return persistenzManager.getById(Wareneingangsmeldung.class, nr);
	}
	//
	// void updateKunde(Kunde kunde) {
	// persistenzManager.update(kunde);
	// }
}
