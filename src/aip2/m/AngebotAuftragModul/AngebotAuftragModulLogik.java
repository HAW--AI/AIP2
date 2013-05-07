package aip2.m.AngebotAuftragModul;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.KundenModul.IKunde;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.IProdukt;

final class AngebotAuftragModulLogik {
	private final AngebotVerwalter angebotVerwalter;
	private final AuftragVerwalter auftragVerwalter;

	AngebotAuftragModulLogik(AngebotVerwalter angebotVerwalter,
			AuftragVerwalter auftragVerwalter) {
		this.angebotVerwalter = angebotVerwalter;
		this.auftragVerwalter = auftragVerwalter;
	}

	List<AngebotTyp> sucheAngebote(KundenTyp kunde) {
		List<Angebot> angebote = angebotVerwalter
				.sucheAngeboteNachKundenNr(kunde.getKundenNr());

		// Wandeln Angebot zu AngebotTyp
		List<AngebotTyp> angebotTypListe = new ArrayList<AngebotTyp>();
		for (Angebot angebot : angebote) {
			AngebotTyp a = angebotVerwalter.getAngebotTyp(angebot);
			angebotTypListe.add(a);
		}
		return angebotTypListe;
	}

	List<AuftragTyp> sucheAuftraege(int rechnungsNr) {
		List<Auftrag> auftraege = auftragVerwalter
				.sucheAuftraegeNachRechnungNr(rechnungsNr);

		List<AuftragTyp> auftragTypsListe = new ArrayList<AuftragTyp>();
		for (Auftrag auftrag : auftraege) {
			AuftragTyp a = auftragVerwalter.getAuftragTyp(auftrag);
			auftragTypsListe.add(a);
		}

		return auftragTypsListe;
	}

	boolean schliesseAbAuftrag(AuftragTyp auftrag) {
		Auftrag retauftrag = auftragVerwalter.getAuftrag(auftrag.getNr());
		retauftrag.setAbgeschlossen(true);
		auftragVerwalter.update(retauftrag);
		return true;
	}

	AuftragTyp erstelleAuftrag(AngebotTyp angebotTyp) {
		Angebot angebot = angebotVerwalter.getAngebot(angebotTyp.getNr());
		Auftrag auftrag = auftragVerwalter.erstelleAuftrag(angebot);
		return auftragVerwalter.getAuftragTyp(auftrag);
	}

	AngebotTyp erstelleAngebot(IKunde kunde, Date angebotsEnde,
			Map<IProdukt, Integer> anzahlProdukte, int preisCent) {
		Angebot angebot = angebotVerwalter.erstelleAngbot(kunde, angebotsEnde,
				anzahlProdukte, preisCent);
		return angebotVerwalter.getAngebotTyp(angebot);
	}

}
