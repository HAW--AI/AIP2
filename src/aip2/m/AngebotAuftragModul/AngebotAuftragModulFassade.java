package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.ProduktModul.Produkt;
import aip2.m.TransaktionModul.ITransaktionIntern;

public final class AngebotAuftragModulFassade implements
		IAngebotAuftragModulExtern {

	private static AngebotAuftragModulFassade kundenFassade;

	@SuppressWarnings("unused")
	private final ITransaktionIntern transaktion;
	@SuppressWarnings("unused")
	private final AngebotAuftragModulLogik angebotAuftragModulLogik;
	private final AngebotVerwalter angebotVerwalter;
	private final AuftragVerwalter auftragVerwalter;

	private AngebotAuftragModulFassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		this.transaktion = transaktion;
		this.angebotVerwalter = new AngebotVerwalter(persistenz);
		this.auftragVerwalter = new AuftragVerwalter(persistenz);
		this.angebotAuftragModulLogik = new AngebotAuftragModulLogik(
				angebotVerwalter, auftragVerwalter);

	}

	public static AngebotAuftragModulFassade getKundenFassade(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (kundenFassade == null)
			kundenFassade = new AngebotAuftragModulFassade(persistenz,
					transaktion);
		return kundenFassade;
	}

	/**
	 * Für JunitTest ONLY !!!
	 */
	AngebotAuftragModulFassade(ITransaktionIntern transaktion,
			AngebotAuftragModulLogik angebotAuftragModulLogik,
			AngebotVerwalter angebotVerwalter, AuftragVerwalter auftragVerwalter) {
		this.transaktion = transaktion;
		this.angebotAuftragModulLogik = angebotAuftragModulLogik;
		this.angebotVerwalter = angebotVerwalter;
		this.auftragVerwalter = auftragVerwalter;
	}

	@Override
	public AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<Produkt, Integer> anzahltProdukte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AngebotTyp> sucheAngebote(KundenTyp kunde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuftragTyp> sucheAuftraege(int RechnungsNr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean schliesseAbAuftrag(AuftragTyp auftrag) {
		// TODO Auto-generated method stub
		return false;
	}

}
