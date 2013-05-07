package aip2.m.TransaktionModul;

import aip2.m.PersistenzModul.IPersistenzSessionIntern;

/**
 * Konfigurator: Stellt die ITransaktionIntern zur Verfügung
 * 
 * TODO für Aufgabe 3 mehrere TransaktionsManager
 */
public final class Transaktion {

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

	// @Deprecated
	// public static ITransaktionIntern getTransaktion() {
	// return getTransaktion(Persistenz.getPersistenzSessionIntern());
	// }

}
