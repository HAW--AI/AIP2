package aip2.m.ProduktModul;

import aip2.m.InterfacesExtern.IProduktModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.WarenmeldungsModul.IWarenmeldungsModulIntern;
import aip2.m.WarenmeldungsModul.WarenmeldungsModul;


/**
 * Factory Klasse konfiguriert und liefert die Produktfassade aus
 * 
 */
public class ProduktModul {
	private static ProduktModulFassade produktFassade;

	private ProduktModul() {
	}
	
	/**
	 * Gibt die einzige Produktfassade zurück. Nach dem ersten Aufruf werden die
	 * Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige Produktfassade
	 */
	public static IProduktModulExtern getProduktFassadeExtern(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}
	
	public static IProduktModulIntern getProduktFassadeIntern(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}
	
	private static ProduktModulFassade fassade(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (produktFassade == null) {
			IWarenmeldungsModulIntern warenmeldungsModulIntern = WarenmeldungsModul.getProduktFassadeIntern(persistenz, transaktion);
			
			ProduktVerwalter produktVerwalter = new ProduktVerwalter(persistenz);
			ProduktModulLogik produktLogik = new ProduktModulLogik(produktVerwalter, warenmeldungsModulIntern);
			
			produktFassade = new ProduktModulFassade(produktLogik, produktVerwalter, transaktion);
		}
		return produktFassade;		
	}
}
