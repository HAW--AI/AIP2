package aip2.m.KundenModul;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Logik der Kunden Komponente
 * 
 */
final class KundenModulLogik {
	private final KundenVerwalter kundenVerwalter;

	KundenModulLogik(KundenVerwalter kv) {
		this.kundenVerwalter = kv;
	}

	public KundenTyp erstelleKunde(String name, String adresse) {
		IKunde kunde = kundenVerwalter.erstelleKunde(name, adresse);
		return kundenVerwalter.getKundenTyp(kunde);
	}

	List<KundenTyp> sucheKunden(String name) {
		List<Kunde> kundenListe = kundenVerwalter.sucheKunde(name);

		// Wandeln Kunde zu KundenTyp
		List<KundenTyp> kundenTypListe = new ArrayList<KundenTyp>();
		for (Kunde kunde : kundenListe) {
			KundenTyp k = kundenVerwalter.getKundenTyp(kunde);
			kundenTypListe.add(k);
		}

		return kundenTypListe;
	}

	KundenTyp sucheKunden(int kundenId) {
		Kunde k = kundenVerwalter.getKundeById(kundenId);
		return kundenVerwalter.getKundenTyp(k);
	}
}
