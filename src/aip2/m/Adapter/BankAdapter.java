package aip2.m.Adapter;

import java.util.Date;
import java.util.Map;

import aip2.externeSysteme.HapSpar;
import aip2.m.RechnungsModul.IRechnungsModulIntern;
import aip2.m.RechnungsModul.IZahlungseingang;

public class BankAdapter {
	private final IRechnungsModulIntern iRechnungsModulIntern;

	public BankAdapter(IRechnungsModulIntern iRechnungsModulExtern) {
		this.iRechnungsModulIntern = iRechnungsModulExtern;
		
//		while (true) {
//			jedeNacht();
//			try {
//				Thread.sleep(24 * 60 * 60 * 1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	public void jedeNacht() {
		Map<Integer, int[]> eingange = HapSpar.getBuchungen();

		for (Integer eingang : eingange.keySet()) {
			for (int zahlung : eingange.get(eingang)) {
				IZahlungseingang z = iRechnungsModulIntern.erzeugeZahlungsEingangReturn(new Date(), zahlung);
				iRechnungsModulIntern.verbucheTeilZahlungseingang(eingang, z);
			}
		}
	}
}
