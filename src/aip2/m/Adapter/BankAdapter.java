package aip2.m.Adapter;

import java.util.Date;
import java.util.Map;

import aip2.externeSysteme.HapSpar;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;

/**
 * Verbindet das HES mit Banken und holt eintreffende Ueberweisungen ab und
 * verbuchen sie
 * 
 */
public class BankAdapter {

	private final IRechnungsModulExtern iRechnungsModulExtern;
	private final HapSparMQListener bankListener;

	public BankAdapter(IRechnungsModulExtern iRechnungsModulExtern) {
		this.iRechnungsModulExtern = iRechnungsModulExtern;
		this.bankListener = new HapSparMQListener(this);
		this.bankListener.start();
	}

	/**
	 * Verbucht eingehende Ueberweisungen im HES System
	 * @param rechnungsNr
	 * @param betrag
	 */
	public void eintreffendeUeberweisung(int rechnungsNr, int betrag) {
		iRechnungsModulExtern.erzeugeZahlungsEingangUndVerbuche(rechnungsNr,
				new Date(), betrag);
	}

	@Deprecated
	public void jedeNacht() {
		Map<Integer, int[]> eingange = HapSpar.getBuchungen();

		for (Integer eingang : eingange.keySet()) {
			for (int zahlung : eingange.get(eingang)) {
				eintreffendeUeberweisung(eingang, zahlung);
			}
		}

		HapSpar.ueberweisungenAbgeholt();
	}

	public void stop() {
		bankListener.stopListener();
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
