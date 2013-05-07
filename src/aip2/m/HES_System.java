package aip2.m;

import aip2.m.AngebotAuftragModul.AngebotAuftragModul;
import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;
import aip2.m.InterfacesExtern.IKundenModulExtern;
import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.InterfacesExtern.IProduktModulExtern;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;
import aip2.m.KundenModul.KundenModul;
import aip2.m.LieferungsModul.LieferungModul;
import aip2.m.PersistenzModul.IPersistenzSessionIntern;
import aip2.m.PersistenzModul.Persistenz;
import aip2.m.ProduktModul.ProduktModul;
import aip2.m.RechnungsModul.RechnungModul;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.TransaktionModul.Transaktion;

/**
 * Startet das komplete System, erstellt alle Module und liefert die Externen
 * Interfaces auf Anfrage aus
 * 
 */
public final class HES_System {

	// Erstellung der einzelnen Modul
	public HES_System(){
		IPersistenzSessionIntern persistenzSession = Persistenz.getPersistenzSessionIntern();
		ITransaktionIntern transaktion = Transaktion.getTransaktion(persistenzSession);
		
		/*
		 *  Erstellung durch das AAModul -> kaskadische Erstellung aller anderen Module
		 *  
		 *  AAModul -> KundenModul
		 *          -> LieferungModul
		 *          -> RechnungModul
		 *          -> ProduktModul -> WarenmeldungsModul
		 */
		AngebotAuftragModul.getIAngebotAuftragModulExtern(persistenzSession, transaktion);
	}	
	
	public IAngebotAuftragModulExtern getIAngebotAuftragModulExtern() {
		return AngebotAuftragModul.getIAngebotAuftragModulExtern(null, null);
	}

	public IKundenModulExtern getIKundenModulExtern() {
		return KundenModul.getIKundenModulExtern(null, null); 
	}
	
	public ILieferungModulExtern getILieferungModulExtern() {
		return LieferungModul.getILieferungModulExtern(null, null); 
	}
	
	public IProduktModulExtern getIProduktModulExtern() {
		return ProduktModul.getIProduktModulExtern(null, null);
	}
	
	public IRechnungsModulExtern getIRechnungsModulExtern() {
		return RechnungModul.getIRechnungsModulExtern(null, null); 
	}
}
