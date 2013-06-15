package aip2.m.LieferungsModul;

import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Stellt die Schnittstelle für externe Operationen und steuert Transaktionen
 * 
 */
final class LieferungModulFassade implements ILieferungModulIntern,
		ILieferungModulExtern {

	private final LieferungModulLogik lieferungModulLogik;
	@SuppressWarnings("unused")
	private final LieferungVerwalter lieferungVerwalter;
	@SuppressWarnings("unused")
	private final TransportauftragVerwalter transportauftragVerwalter;
	private final ITransaktionIntern transaktion;

	LieferungModulFassade(LieferungModulLogik lieferungModulLogik,
			LieferungVerwalter lieferungVerwalter,
			TransportauftragVerwalter transportauftragVerwalter,
			ITransaktionIntern transaktion) {
		this.lieferungVerwalter = lieferungVerwalter;
		this.transportauftragVerwalter = transportauftragVerwalter;
		this.lieferungModulLogik = lieferungModulLogik;
		this.transaktion = transaktion;
	}

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
	public ILieferung erzeugeLieferung(String adresse/*IAuftrag auftrag*/) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			ILieferung lieferung = lieferungModulLogik.erzeugeLieferung(adresse);

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
