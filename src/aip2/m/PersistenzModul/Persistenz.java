package aip2.m.PersistenzModul;

/**
 * Konfigurator: Stellt die IPersitenzIntern zur Verfügung
 * 
 */
public class Persistenz {
	private static PersistenzManager perisistenzManager = null;

	private Persistenz() {
	};

	public static IPersistenzIntern getPersistenz() {
		if (Persistenz.perisistenzManager == null) {
			Persistenz.perisistenzManager = new PersistenzManager();
		}
		return Persistenz.perisistenzManager;
	}

	public static IPersistenzSessionIntern getPersistenzSessionIntern() {
		if (Persistenz.perisistenzManager == null) {
			Persistenz.perisistenzManager = new PersistenzManager();
		}
		return Persistenz.perisistenzManager;
	}

}
