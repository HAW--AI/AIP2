package aip2.m.RechnungsModul;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Logik der Rechnugs Komponente
 * 
 */
final class RechnungModulLogik {

	private final RechnungVerwalter rechnungVerwalter;
	private final ZahlungseingangVerwalter zahlungseingangVerwalter;

	RechnungModulLogik(RechnungVerwalter rechnungVerwalter,
			ZahlungseingangVerwalter zahlungseingangVerwalter) {
		this.rechnungVerwalter = rechnungVerwalter;
		this.zahlungseingangVerwalter = zahlungseingangVerwalter;
	}

	IRechnung verbucheTeilZahlungseingang(int rechnungsNr,
			IZahlungseingang izahlungseingang) {

		Rechnung rechnung = rechnungVerwalter.sucheRechnung(rechnungsNr);
		Zahlungseingang zahlungseingang = zahlungseingangVerwalter
				.getZahlungseingang(izahlungseingang.getZahlungseingangNr());

		zahlungseingang.setRechnung(rechnung);
		zahlungseingangVerwalter.updateZahlungsEingang(zahlungseingang);

		rechnung.addZahlungseingang(zahlungseingang);
		rechnungVerwalter.updateRechnung(rechnung);

		int bezahlt = 0;
		for (IZahlungseingang zahlung : rechnung.getZahlungseingaenge()) {
			bezahlt += zahlung.getBetragCent();
		}

		if (bezahlt >= rechnung.getPreis()) {
			rechnung.setIstBezahlt(true);
			rechnungVerwalter.updateRechnung(rechnung);
		}
		return rechnung;
	}

	List<RechnungTyp> sucheBezahlteRechnungen() {
		List<Rechnung> listRechnungen = rechnungVerwalter
				.sucheBezahlteRechnungen();
		List<RechnungTyp> rechnungsTypListe = new ArrayList<RechnungTyp>();
		for (IRechnung iRechnung : listRechnungen) {
			RechnungTyp rt = rechnungVerwalter.getRechnungsTyp(iRechnung);
			rechnungsTypListe.add(rt);
		}
		return rechnungsTypListe;
	}
}
