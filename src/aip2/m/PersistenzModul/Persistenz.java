package aip2.m.PersistenzModul;

/**
 * Konfigurator: Stellt die IPersitenzIntern zur Verfügung
 * 
 * 
 * TODO für Aufgabe 3 mehere Sessions für multitreading
 * 
 * NoTO DO für Aufgabe 3 eventuell @Cascade({ CascadeType.SAVE_UPDATE })
 * 
 * TODO: für Aufgabe 3 Unnötige Entitäten bei allen entfernen
 */
public final class Persistenz {
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
