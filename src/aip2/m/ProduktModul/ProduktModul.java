package aip2.m.ProduktModul;

import aip2.m.InterfacesExtern.IProduktModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;


/**
 * Factory Klasse konfiguriert und liefert die Produktfassade aus
 * 
 */
public class ProduktModul {
	private static ProduktModulFassade produktFassade;

	/**
	 * Gibt die einzige Produktfassade zurück. Nach dem ersten Aufruf werden die
	 * Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige Produktfassade
	 */
	public static IProduktModulExtern getProduktFassade(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (produktFassade == null) {
			ProduktVerwalter produktVerwalter = new ProduktVerwalter(persistenz);
			ProduktModulLogik produktLogik = new ProduktModulLogik(produktVerwalter);
			produktFassade = new ProduktModulFassade(produktLogik, produktVerwalter, transaktion);
		}
		return produktFassade;
	}
}
