package aip2.m.LieferungsModul;

import java.util.Date;

import aip2.m.Adapter.TransportdienstleisterAdapter;


final class LieferungModulLogik {
	private final LieferungVerwalter lieferungVerwalter;
	private final TransportauftragVerwalter transportauftragVerwalter;
	private final TransportdienstleisterAdapter transportdienstleisterAdapter;
	
	LieferungModulLogik(LieferungVerwalter lieferungVerwalter,
			TransportauftragVerwalter transportauftragVerwalter,
			TransportdienstleisterAdapter transportdienstleisterAdapter) {
		this.lieferungVerwalter = lieferungVerwalter;
		this.transportauftragVerwalter = transportauftragVerwalter;
		this.transportdienstleisterAdapter = transportdienstleisterAdapter;
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

	public ILieferung erzeugeLieferung(String adresse) {
		Transportauftrag transportauftrag = transportauftragVerwalter.erstelleTransportauftrag(new Date(), "DLH");
		ILieferung lieferung = lieferungVerwalter.erstelleLieferung(transportauftrag);
		transportauftrag.setLieferung(lieferung);	
		
		String verfolgungsId = transportdienstleisterAdapter.sendeTransportAuftrag(lieferung.getLieferungsNr(), adresse);
		transportauftrag.setTransportVerfolgungsId(verfolgungsId);
		
		transportauftragVerwalter.updateTransportauftrag(transportauftrag);
		return lieferung;
	}
	
	public void setTrackingCode(int lieferungsId, String trackingCode) {
		Lieferung lieferung = lieferungVerwalter.getLieferung(lieferungsId);
		ITransportauftrag iauftrag = lieferung.getTransportauftrag();
		Transportauftrag auftrag = transportauftragVerwalter.getTransportauftrag(iauftrag.getTransportAuftragNr());
		auftrag.setTransportVerfolgungsId(trackingCode);
		transportauftragVerwalter.updateTransportauftrag(auftrag);
		
	}
}
