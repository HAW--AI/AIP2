package aip2.m.RechnungsModul;

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

		int bezahlt = 0;
		for (IZahlungseingang zahlung : rechnung.getZahlungseingaenge()) {
			bezahlt += zahlung.getBetragCent();
		}
		
		//TODO lod oder betrag in Rechnung?
		if(bezahlt >= rechnung.getAuftrag().getAngebot().getGesamtpreis()){
			rechnung.setIstBezahlt(true);
			rechnungVerwalter.updateRechnung(rechnung);
		}
		
		return rechnung;
	}
}
