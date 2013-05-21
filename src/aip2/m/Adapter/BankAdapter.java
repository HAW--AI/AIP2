package aip2.m.Adapter;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import aip2.externeSysteme.HapSpar;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;

public class BankAdapter {
	private final IRechnungsModulExtern iRechnungsModulExtern;

	public BankAdapter(IRechnungsModulExtern iRechnungsModulExtern) {
		this.iRechnungsModulExtern = iRechnungsModulExtern;

		// while (true) {
		// jedeNacht();
		// try {
		// Thread.sleep(24 * 60 * 60 * 1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
	}

	public void jedeNacht() {
		Map<Integer, int[]> eingange = HapSpar.getBuchungen();

		for (Integer eingang : eingange.keySet()) {
			for (int zahlung : eingange.get(eingang)) {
				try {
					iRechnungsModulExtern.erzeugeZahlungsEingangUndVerbuche(
							eingang, new Date(), zahlung);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		HapSpar.ueberweisungenAbgeholt();
	}
}
