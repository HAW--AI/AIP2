package aip2.m.LieferungsModul;

import java.util.Date;

import aip2.m.PersistenzModul.IPersistenzIntern;

/**
 * Verwaltet Transportauftrag Entitäten
 * 
 */
final class TransportauftragVerwalter {
	private final IPersistenzIntern persistenz;

	TransportauftragVerwalter(IPersistenzIntern persistenz) {
		this.persistenz = persistenz;
	}

	Transportauftrag erstelleTransportauftrag(Date ausgangsDatum,
			String transportDienstleister) {
		Transportauftrag transportauftrag = new Transportauftrag(ausgangsDatum,
				transportDienstleister);

		persistenz.add(transportauftrag);

		return transportauftrag;
	}

	Transportauftrag getTransportauftrag(int nr) {
		return persistenz.getById(Transportauftrag.class, nr);
	}

	void updateTransportauftrag(ITransportauftrag transportauftrag) {
		persistenz.update(transportauftrag);
	}

}
