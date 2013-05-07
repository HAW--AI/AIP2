package aip2.m.AngebotAuftragModul;

import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;


public final class AngebotAuftragModul {
	private static AngebotAuftragModulFassade angebotAuftragModulFassade;

	public static IAngebotAuftragModulExtern getIAngebotAuftragModulExtern() {
		// TODO
		
		/*AngebotAuftragModulFassade(IPersistenzIntern persistenz,
				ITransaktionIntern transaktion) {
			this.transaktion = transaktion;
			this.angebotVerwalter = new AngebotVerwalter(persistenz);
			this.auftragVerwalter = new AuftragVerwalter(persistenz);
			this.angebotAuftragModulLogik = new AngebotAuftragModulLogik(
					angebotVerwalter, auftragVerwalter);
		*/
		return angebotAuftragModulFassade;
	}
}
