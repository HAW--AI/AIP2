package aip2.m.AngebotAuftragModul;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.KundenModul.IKunde;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.LieferungsModul.ILieferungModulIntern;
import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.IProduktModulIntern;
import aip2.m.RechnungsModul.IRechnungsModulIntern;

/**
 * Die Logik der angebot Auftrags Komponente
 * 
 */
final class AngebotAuftragModulLogik {
	private final AngebotVerwalter angebotVerwalter;
	private final AuftragVerwalter auftragVerwalter;
	private final ILieferungModulIntern iLieferungModulIntern;
	private final IProduktModulIntern iProduktModulIntern;
	private final IRechnungsModulIntern iRechnungsModulIntern;
	
	
	AngebotAuftragModulLogik(AngebotVerwalter angebotVerwalter,
			AuftragVerwalter auftragVerwalter, ILieferungModulIntern iLieferungModulIntern,
			IProduktModulIntern iProduktModulIntern, IRechnungsModulIntern iRechnungsModulIntern) {
		this.angebotVerwalter = angebotVerwalter;
		this.auftragVerwalter = auftragVerwalter;
		this.iLieferungModulIntern = iLieferungModulIntern;
		this.iProduktModulIntern = iProduktModulIntern;
		this.iRechnungsModulIntern = iRechnungsModulIntern;
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
		Auftrag retauftrag = auftragVerwalter.getAuftrag(auftrag
				.getAuftragsNr());
		retauftrag.setAbgeschlossen(true);
		auftragVerwalter.update(retauftrag);
		return true;
	}

	AuftragTyp erstelleAuftrag(AngebotTyp angebotTyp) {
		Angebot angebot = angebotVerwalter.getAngebot(angebotTyp.getAngebotsNr());
		Auftrag auftrag = auftragVerwalter.erstelleAuftrag(angebot);
		
		// Hier fehlt etwas Logik weil das Sequenzdiangramm falsch ist :D
		// In erstelleAuftrag wird natürlich dann durch die Produkte durchgegangen und lagereAus etc aufgerufen
		// Wie mit "Verspätungen" umgegangen wird müssen wir noch klären, aber die Rechnung wird sicherlich direkt erstellt
		for (IProdukt p : angebot.getProdukte().keySet()) {
			iProduktModulIntern.lagereAusProdukt(p, angebot.getProdukte().get(p));
		}		
		iLieferungModulIntern.erzeugeLieferung(auftrag); // ???
		iRechnungsModulIntern.erzeugeRechnung(auftrag);
		
		return auftragVerwalter.getAuftragTyp(auftrag);
	}

	AngebotTyp erstelleAngebot(IKunde kunde, Date angebotsEnde,
			Map<IProdukt, Integer> anzahlProdukte, int preisCent) {
		Angebot angebot = angebotVerwalter.erstelleAngbot(kunde, angebotsEnde,
				anzahlProdukte, preisCent);
		return angebotVerwalter.getAngebotTyp(angebot);
	}

}
