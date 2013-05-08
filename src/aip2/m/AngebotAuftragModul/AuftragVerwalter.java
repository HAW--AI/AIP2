package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.List;

import aip2.m.PersistenzModul.IPersistenzIntern;

/**
 * Verwaltet Auftrags Entitäten und erzeugt den Fachlichen Datentypen
 * 
 */
final class AuftragVerwalter {
	private final IPersistenzIntern persistenzManager;

	AuftragVerwalter(IPersistenzIntern pm) {
		this.persistenzManager = pm;
	}

	List<Auftrag> sucheAuftraegeNachRechnungNr(int rechnungsNr) {
		return persistenzManager.getFromWhere(Auftrag.class,
				"rechnung_rechnung_nr", rechnungsNr);

	}

	AuftragTyp getAuftragTyp(Auftrag auftrag) {
		AuftragTyp auftragTyp = new AuftragTyp(auftrag.getAuftragsNr(),
				auftrag.isAbgeschlossen(), auftrag.getBeauftragtAm(), auftrag
						.getLieferung().getLieferungsNr(), auftrag
						.getRechnung().getRechnungsNr(), auftrag.getAngebot().getAngebotsNr()
		/* , auftrag.getLieferung(), auftrag.getRechnung(),auftrag.getAngebot() */);
		return auftragTyp;
	}

	Auftrag getAuftrag(int nr) {
		return persistenzManager.getById(Auftrag.class, nr);
	}

	void update(Auftrag auftrag) {
		persistenzManager.update(auftrag);
	}

	Auftrag erstelleAuftrag(Angebot angebot) {
		Auftrag auftrag = new Auftrag(new Date(), angebot);
		persistenzManager.add(auftrag);
		return auftrag;
	}
}
