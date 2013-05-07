package aip2.m.LieferungsModul;

import java.util.Date;

import aip2.m.AngebotAuftragModul.IAuftrag;

final class LieferungModulLogik {

	private final LieferungVerwalter lieferungVerwalter;
	private final TransportauftragVerwalter transportauftragVerwalter;

	LieferungModulLogik(LieferungVerwalter lieferungVerwalter,
			TransportauftragVerwalter transportauftragVerwalter) {
		this.lieferungVerwalter = lieferungVerwalter;
		this.transportauftragVerwalter = transportauftragVerwalter;
	}

	public boolean bestaetigeLieferung(int lieferungsNummer) {
		Lieferung lieferung = lieferungVerwalter.getLieferung(lieferungsNummer);
		Transportauftrag transportauftrag = transportauftragVerwalter
				.getTransportauftrag(lieferung.getTransportauftrag()
						.getTransportAuftragNr());

		transportauftrag.setLieferungErfolgt(true);
		transportauftrag.setLieferDatum(new Date());
		transportauftragVerwalter.updateTransportauftrag(transportauftrag);

		return true;
	}

	public ILieferung erzeugeLieferung(IAuftrag auftrag) {
		Transportauftrag transportauftrag = transportauftragVerwalter
				.erstelleTransportauftrag(new Date(), "DLH");

		ILieferung lieferung = lieferungVerwalter
				.erstelleLieferung(transportauftrag);
		transportauftrag.setLieferung(lieferung);
		transportauftragVerwalter.updateTransportauftrag(transportauftrag);

		return lieferung;
	}
}
