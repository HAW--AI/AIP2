package aip2.m.RechnungsModul;

import java.util.Date;

import aip2.m.PersistenzModul.IPersistenzIntern;

/**
 * Verwaltet Zahlungseingang Entitäten
 * 
 */
final class ZahlungseingangVerwalter {
	private final IPersistenzIntern persistenz;

	ZahlungseingangVerwalter(IPersistenzIntern persistenz) {
		this.persistenz = persistenz;
	}

	IZahlungseingang erstelleZahlungsEingang(Date datum, int betragCent) {
		IZahlungseingang zahlungseingang = new Zahlungseingang(datum,
				betragCent);

		persistenz.add(zahlungseingang);

		return zahlungseingang;
	}

	Zahlungseingang getZahlungseingang(int nr) {
		return persistenz.getById(Zahlungseingang.class, nr);
	}

	void updateZahlungsEingang(IZahlungseingang zahlungseingang) {
		persistenz.update(zahlungseingang);
	}

}
