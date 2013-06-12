package aip2.m.Adapter;

import java.util.Date;
import java.util.Map;

import aip2.externeSysteme.HapSpar;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;

public class BankAdapter {

	private final IRechnungsModulExtern iRechnungsModulExtern;
	private final BankListener bankListener;

	public BankAdapter(IRechnungsModulExtern iRechnungsModulExtern) {
		this.iRechnungsModulExtern = iRechnungsModulExtern;
		this.bankListener = new BankListener(this);
	}

	public void eintreffendeUeberweisung(int rechnungsNr, int betrag) {
		iRechnungsModulExtern.erzeugeZahlungsEingangUndVerbuche(rechnungsNr,
				new Date(), betrag);
	}
	
	public void start(){
		bankListener.start();
	}
	
	public void stop(){
		bankListener.stopListener();
	}

	@Deprecated
	public void jedeNacht() {
		Map<Integer, int[]> eingange = HapSpar.getBuchungen();

		for (Integer eingang : eingange.keySet()) {
			for (int zahlung : eingange.get(eingang)) {
				eintreffendeUeberweisung( eingang,  zahlung);
			}
		}

		HapSpar.ueberweisungenAbgeholt();
	}
}

// while (true) {
// jedeNacht();
// try {
// Thread.sleep(24 * 60 * 60 * 1000);
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }
