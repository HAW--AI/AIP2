package aip2.externeSysteme;

import java.util.HashMap;
import java.util.Map;

public class HapSpar {

	private static Map<Integer, int[]> zahlungen = new HashMap<Integer, int[]>();

	public static Map<Integer, int[]> getBuchungen() {
		return zahlungen;
	}

	public static boolean ueberweise(int betreff, int[] einzelUeberweisungen) {
		zahlungen.put(betreff, einzelUeberweisungen);
		return true;
	}

	public static boolean ueberweisungenAbgeholt() {
		zahlungen.clear();
		return true;
	}
}
