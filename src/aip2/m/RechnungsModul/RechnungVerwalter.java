package aip2.m.RechnungsModul;

import java.util.Date;

import aip2.m.AngebotAuftragModul.IAuftrag;
import aip2.m.PersistenzModul.IPersistenzIntern;

final class RechnungVerwalter {

	private IPersistenzIntern persistenzManager;

	RechnungVerwalter(IPersistenzIntern persistenz) {
		this.persistenzManager = persistenz;
	}
	
	Rechnung sucheRechnung(int nr){
		return persistenzManager.getById(Rechnung.class, nr);
	}

	IRechnung erstelleRechnung(IAuftrag auftrag) {
		IRechnung rechnung = new Rechnung(new Date(), false, auftrag);
		
		persistenzManager.add(rechnung);
		
		return rechnung;
	}
	
	void updateRechnung(IRechnung rechnung){
		persistenzManager.update(rechnung);
	}

}
