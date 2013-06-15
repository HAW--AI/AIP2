package aip2.m.LieferungsModul;

import aip2.m.Adapter.TransportdienstleisterAdapter;
import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

public final class LieferungModul {
	private static LieferungModulFassade lieferungModulFassade;
//	private static TransportdienstleisterAdapter transportdienstleisterAdapter;

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

	@Deprecated
	public static TransportdienstleisterAdapter getTransportdienstleisterAdapter() {
//		return transportdienstleisterAdapter;
		return null;
	}

	private static LieferungModulFassade fassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		if (lieferungModulFassade == null) {
			LieferungVerwalter lieferungVerwalter = new LieferungVerwalter(persistenz);
			TransportdienstleisterAdapter transportdienstleisterAdapter = 
					new TransportdienstleisterAdapter(lieferungModulFassade);			
			TransportauftragVerwalter transportauftragVerwalter = new TransportauftragVerwalter(persistenz);
			LieferungModulLogik lieferungModulLogik = new LieferungModulLogik(lieferungVerwalter, transportauftragVerwalter,
					transportdienstleisterAdapter);
			lieferungModulFassade = new LieferungModulFassade(lieferungModulLogik, lieferungVerwalter,
					transportauftragVerwalter, transaktion);
		}
		return lieferungModulFassade;
	}
}
