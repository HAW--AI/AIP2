package aip2.m.LieferungsModul;

import aip2.m.AngebotAuftragModul.IAuftrag;
import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

public class LieferungModulFassade implements ILieferungModulIntern,
		ILieferungModulExtern {

	private static LieferungModulFassade lieferungModulFassade;
	
	private final LieferungModulLogik lieferungModulLogik;
	private final LieferungVerwalter lieferungVerwalter;
	private final TransportauftragVerwalter transportauftragVerwalter;
	private final ITransaktionIntern transaktion;
	
	
	private LieferungModulFassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		this.transaktion = transaktion;
		this.lieferungVerwalter = new LieferungVerwalter(persistenz);
		this.transportauftragVerwalter = new TransportauftragVerwalter(persistenz);
		this.lieferungModulLogik = new LieferungModulLogik(lieferungVerwalter, transportauftragVerwalter);
	}

	public static LieferungModulFassade startLieferungFassade(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (lieferungModulFassade == null)
			lieferungModulFassade = new LieferungModulFassade(persistenz, transaktion);
		return lieferungModulFassade;
	}

	/**
	 * Für JunitTest ONLY !!!
	 */
//	LieferungModulFassade(RechnungModulLogik rechnungModulLogik,
//			RechnungVerwalter rechnungVerwalter,
//			ZahlungseingangVerwalter zahlungseingangVerwalter,
//			ITransaktionIntern transaktion) {
//		this.rechnungModulLogik = rechnungModulLogik;
//		this.rechnungVerwalter = rechnungVerwalter;
//		this.zahlungseingangVerwalter = zahlungseingangVerwalter;
//		this.transaktion = transaktion;
//	}
	
	@Override
	public boolean bestaetigeLieferung(int lieferungsNummer) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			lieferungModulLogik.bestaetigeLieferung(lieferungsNummer);

			if (myTransaction)
				transaktion.commitTransaction();

			return true;

		} catch (Exception e) {
			transaktion.rollbackTransaction();
		}
		return false;
	}

	@Override
	public ILieferung erzeugeLieferung(IAuftrag auftrag) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			ILieferung lieferung = lieferungModulLogik.erzeugeLieferung(auftrag);

			if (myTransaction)
				transaktion.commitTransaction();

			if (lieferung != null)
				return lieferung;

		} catch (Exception e) {
			transaktion.rollbackTransaction();
		}
		return null;
	}

}
