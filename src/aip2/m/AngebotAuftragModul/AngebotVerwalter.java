package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.KundenModul.IKunde;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.ProduktModul.IProdukt;

/**
 * Verwaltet Angebots Entitäten und erzeugt den Fachlichen Datentypen
 * 
 */
final class AngebotVerwalter {

	private final IPersistenzIntern persistenzManager;

	AngebotVerwalter(IPersistenzIntern pm) {
		this.persistenzManager = pm;
	}

	List<Angebot> sucheAngeboteNachKundenNr(int kundenNr) {
		return persistenzManager.getFromWhere(Angebot.class, "kunde_kunde_nr",
				kundenNr);
	}

	AngebotTyp getAngebotTyp(Angebot angebot) {
		AngebotTyp angebotTyp = new AngebotTyp(angebot.getAngebotsNr(),
				angebot.getGueltigAb(), angebot.getGueltigBis(),
				angebot.getGesamtpreis()
		/* , angebot.getAuftrag(),angebot.getKunde() , angebot.getProdukte() */);
		return angebotTyp;
	}

	Angebot getAngebot(int nr) {
		return persistenzManager.getById(Angebot.class, nr);
	}

	Angebot erstelleAngbot(IKunde kunde, Date angebotsEnde,
			Map<IProdukt, Integer> anzahlProdukte, int preisCent) {
		Angebot angebot = new Angebot(new Date(), angebotsEnde, preisCent,
				kunde, anzahlProdukte);
		persistenzManager.add(angebot);
		return angebot;
	}

}
