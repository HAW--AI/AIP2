package aip2.m.Adapter;

import java.util.Date;
import java.util.List;

import aip2.externeSysteme.HapSpar;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;

public class BankAdapter {

	private final IRechnungsModulExtern iRechnungsModulExtern;

	// private final HapSpar hapSpar;

	public BankAdapter(IRechnungsModulExtern iRechnungsModulExtern
	// , HapSpar hapSpar
	) {
		this.iRechnungsModulExtern = iRechnungsModulExtern;
		// this.hapSpar = hapSpar;
	}

	public void jedeNacht() {
		List<Integer> eingange = HapSpar.getBuchungen();

		for (Integer eingang : eingange) {
			iRechnungsModulExtern.erzeugeZahlungsEingang(new Date(), eingang);
		}
	}
}
