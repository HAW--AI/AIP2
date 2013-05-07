package aip2.m.LieferungsModul;

import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

public class LieferungModul {
	private static LieferungModulFassade lieferungModulFassade;

	private LieferungModul() {
	}

	public static ILieferungModulExtern getILieferungModulExtern(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}

	public static ILieferungModulIntern getILieferungModulIntern(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}

	private static LieferungModulFassade fassade(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (lieferungModulFassade == null) {
			LieferungVerwalter lieferungVerwalter = new LieferungVerwalter(
					persistenz);
			TransportauftragVerwalter transportauftragVerwalter = new TransportauftragVerwalter(
					persistenz);
			LieferungModulLogik lieferungModulLogik = new LieferungModulLogik(
					lieferungVerwalter, transportauftragVerwalter);
			lieferungModulFassade = new LieferungModulFassade(
					lieferungModulLogik, lieferungVerwalter,
					transportauftragVerwalter, transaktion);
		}
		return lieferungModulFassade;
	}
}
