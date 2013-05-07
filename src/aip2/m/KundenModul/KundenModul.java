package aip2.m.KundenModul;

import aip2.m.InterfacesExtern.IKundenModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Factory Klasse konfiguriert und liefert die Kundenfassade aus
 * 
 */
public class KundenModul {
	private static KundenModulFassade kundenFassade;

	private KundenModul() {
	}

	/**
	 * Gibt die einzige KundenFassade zurück. Nach dem ersten Aufruf werden die
	 * Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige Kundenfassade
	 */
	public static IKundenModulExtern getIKundenModulExtern(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (kundenFassade == null) {
			KundenVerwalter kundenVerwalter = new KundenVerwalter(persistenz);
			KundenModulLogik kundenLogik = new KundenModulLogik(kundenVerwalter);
			kundenFassade = new KundenModulFassade(kundenLogik,
					kundenVerwalter, transaktion);
		}
		return kundenFassade;
	}

	/**
	 * Gibt die einzige KundenFassade zurück. Nach dem ersten Aufruf werden die
	 * Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige Kundenfassade
	 */
	public static IKundenModulIntern getIKundeIntern(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		if (kundenFassade == null) {
			KundenVerwalter kundenVerwalter = new KundenVerwalter(persistenz);
			KundenModulLogik kundenLogik = new KundenModulLogik(kundenVerwalter);
			kundenFassade = new KundenModulFassade(kundenLogik,
					kundenVerwalter, transaktion);
		}
		return kundenFassade;
	}
}
