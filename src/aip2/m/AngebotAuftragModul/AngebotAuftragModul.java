package aip2.m.AngebotAuftragModul;

import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;
import aip2.m.KundenModul.IKundenModulIntern;
import aip2.m.KundenModul.KundenModul;
import aip2.m.LieferungsModul.ILieferungModulIntern;
import aip2.m.LieferungsModul.LieferungModul;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.ProduktModul.IProduktModulIntern;
import aip2.m.ProduktModul.ProduktModul;
import aip2.m.RechnungsModul.IRechnungsModulIntern;
import aip2.m.RechnungsModul.RechnungModul;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Factory Klasse konfiguriert und liefert die AAfassade aus
 * 
 */
public final class AngebotAuftragModul {

	private static AngebotAuftragModulFassade angebotAuftragModulFassade;

	private AngebotAuftragModul() {
	}

	/**
	 * Gibt die einzige AngebotAuftragModulFassade zurück. Nach dem ersten
	 * Aufruf werden die Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige AngebotAuftragModulFassade
	 */
	public static IAngebotAuftragModulExtern getIAngebotAuftragModulExtern(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (angebotAuftragModulFassade == null) {
			IKundenModulIntern iKundeIntern = KundenModul.getIKundeIntern(persistenz, transaktion);
			ILieferungModulIntern iLieferungModulIntern = LieferungModul.getILieferungModulIntern(persistenz, transaktion);
			IProduktModulIntern iProduktModulIntern = ProduktModul.getIProduktModulIntern(persistenz, transaktion);
			IRechnungsModulIntern iRechnungsModulIntern = RechnungModul.getIRechnungsModulIntern(persistenz, transaktion);
			
			AngebotVerwalter angebotVerwalter = new AngebotVerwalter(persistenz);
			AuftragVerwalter auftragVerwalter = new AuftragVerwalter(persistenz);
			AngebotAuftragModulLogik angebotAuftragModulLogik = new AngebotAuftragModulLogik(angebotVerwalter,
					auftragVerwalter, iLieferungModulIntern, iProduktModulIntern, iRechnungsModulIntern);

			angebotAuftragModulFassade = new AngebotAuftragModulFassade(transaktion, angebotAuftragModulLogik, angebotVerwalter,
					auftragVerwalter, iProduktModulIntern, iKundeIntern);
		}
		return angebotAuftragModulFassade;
	}
}
