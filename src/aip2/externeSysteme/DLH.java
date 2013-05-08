package aip2.externeSysteme;

import java.util.ArrayList;
import java.util.List;

public class DLH {

	private static List<Integer> abgelieferteLieferungsNr = new ArrayList<Integer>();

	public static List<Integer> getAbgelieferteLieferungen() {
		return abgelieferteLieferungsNr;
	}

	public static boolean lieferantHatAbgeliefertNr(int lieferungsNr) {
		abgelieferteLieferungsNr.add(lieferungsNr);
		return true;
	}

	public static boolean abgelieferteLieferungenAbgeholt() {
		abgelieferteLieferungsNr.clear();
		return true;
	}
}
