package aip2.m.TransaktionModul;

import aip2.m.PersistenzModul.IPersistenzSessionIntern;
import aip2.m.PersistenzModul.Persistenz;

/**
 * Konfigurator: Stellt die ITransaktionIntern zur Verfügung
 * 
 */
public class Transaktion {

	private static TransaktionManager transaktionManager = null;

	private Transaktion() {
	}

	public static ITransaktionIntern getTransaktion(
			IPersistenzSessionIntern persistenz) {
		if (Transaktion.transaktionManager == null) {
			Transaktion.transaktionManager = new TransaktionManager(persistenz);
		}
		return Transaktion.transaktionManager;
	}

	// TODO richtiges DI?
	public static ITransaktionIntern getTransaktion() {
		return getTransaktion(Persistenz.getPersistenzSessionIntern());
	}

}
