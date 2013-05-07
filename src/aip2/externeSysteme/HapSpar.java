package aip2.externeSysteme;

import java.util.HashMap;
import java.util.Map;

public class HapSpar {
	
	public static Map<Integer, int[]> getBuchungen(){
		Map<Integer, int[]> zahlungen = new HashMap<Integer, int[]>(3);
		zahlungen.put(0, new int[] {25});
		zahlungen.put(1, new int[] {30, 30});
		zahlungen.put(2, new int[] {40});
		return zahlungen;
	}
}
