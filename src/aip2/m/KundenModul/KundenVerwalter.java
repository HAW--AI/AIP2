package aip2.m.KundenModul;

import java.util.List;

import aip2.m.PersistenzModul.IPersistenzIntern;

/**
 * Verwalter Kunden: erstellt, sucheNachNamen und erzeugt den Fachlichen
 * Datentyp KundenTyp
 * 
 */
final class KundenVerwalter {

	private IPersistenzIntern persistenzManager;

	KundenVerwalter(IPersistenzIntern pm) {
		this.persistenzManager = pm;
	}

	Kunde erstelleKunde(String name, String adresse) {
		Kunde k = new Kunde(name, adresse);

		persistenzManager.add(k);

		return k;
	}

	List<Kunde> sucheKunde(String name) {
		return persistenzManager.getFromWhere(Kunde.class, "name", name);
	}

	KundenTyp getKundenTyp(IKunde kunde) {
		KundenTyp kundenTyp = new KundenTyp(kunde.getKundenNr(),
				kunde.getName(), kunde.getAdresse(), kunde.getAngebote());
		return kundenTyp;
	}

	// Kunde getKundeById(int nr) {
	// return persistenzManager.getById(Kunde.class, nr);
	// }
	//
	// void updateKunde(Kunde kunde) {
	// persistenzManager.update(kunde);
	// }
}
