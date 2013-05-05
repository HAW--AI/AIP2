package aip2.m.KundenModul;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Logik der Kunden Komponente
 *
 */
class KundenLogik {
	private final KundenVerwalter kundenVerwalter;

	KundenLogik(KundenVerwalter kv) {
		this.kundenVerwalter = kv;
	}

	List<KundenTyp> sucheKunden(String name) {
		List<Kunde> kundenListe = kundenVerwalter.sucheKunde(name);

		//Wandeln Kunde zu KundenTyp
		List<KundenTyp> kundenTypListe = new ArrayList<KundenTyp>();
		for (Kunde kunde : kundenListe) {
			KundenTyp k = kundenVerwalter.getKundenTyp(kunde);
			kundenTypListe.add(k);
		}

		return kundenTypListe;
	}
}
