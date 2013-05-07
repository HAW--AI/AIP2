package aip2.m.InterfacesExtern;

import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.Produkt;

public interface IAngebotAuftragModulExtern {

	AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<Produkt, Integer> anzahltProdukte);
	
	List<AngebotTyp> sucheAngebote(KundenTyp kunde);
	
	AuftragTyp erstelleAuftrag(AngebotTyp angebot);
	
	List<AuftragTyp> sucheAuftraege(int RechnungsNr);
	
	boolean schliesseAbAuftrag(AuftragTyp auftrag);

}
