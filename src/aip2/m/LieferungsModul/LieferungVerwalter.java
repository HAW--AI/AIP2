package aip2.m.LieferungsModul;

import aip2.m.PersistenzModul.IPersistenzIntern;

final class LieferungVerwalter {
	private final IPersistenzIntern persistenz;

	LieferungVerwalter(IPersistenzIntern persistenz) {
		this.persistenz = persistenz;
	}

	ILieferung erstelleLieferung(ITransportauftrag transportauftrag) {
		ILieferung lieferung = new Lieferung(transportauftrag);

		persistenz.add(lieferung);
		return lieferung;
	}

	Lieferung getLieferung(int nr) {
		return persistenz.getById(Lieferung.class, nr);
	}

	void updateLieferung(ILieferung lieferung) {
		persistenz.update(lieferung);
	}

}
