package aip2.m.WarenmeldungsModul;

import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

public class WarenmeldungsModul {
	private static WarenmeldungsModulFassade warenmeldungsModulFassade;

	private WarenmeldungsModul() {
	}
	
	public static IWarenmeldungsModulIntern getProduktFassadeIntern(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}
	
	private static WarenmeldungsModulFassade fassade(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (warenmeldungsModulFassade == null) {
			WarenmeldungsVerwalter warenmeldungsVerwalter = new WarenmeldungsVerwalter(persistenz);
			WarenmeldungsModulLogik produktLogik = new WarenmeldungsModulLogik(warenmeldungsVerwalter);
			warenmeldungsModulFassade = new WarenmeldungsModulFassade(produktLogik, warenmeldungsVerwalter, transaktion);
		}
		return warenmeldungsModulFassade;		
	}
}
