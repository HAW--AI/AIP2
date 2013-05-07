package aip2.m.AngebotAuftragModul;

import aip2.m.PersistenzModul.IPersistenzIntern;

class AngebotVerwalter {

	private final IPersistenzIntern persistenzManager;

	AngebotVerwalter(IPersistenzIntern pm) {
		this.persistenzManager = pm;
	}
	
	Angebot erstelleAngebot(){
		//TODO
		Angebot angebot = null;
		persistenzManager.add(angebot);
		
		return angebot;
	}

}
