package aip2.m.RechnungsModul;

import java.util.Date;

import aip2.m.AngebotAuftragModul.IAuftrag;

import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

public class RechnungModulFassade implements IRechnungsModulIntern {

	private static RechnungModulFassade rechnungModulFassade;

	private final RechnungModulLogik rechnungModulLogik;
	private final RechnungVerwalter rechnungVerwalter;
	private final ZahlungseingangVerwalter zahlungseingangVerwalter;
	private final ITransaktionIntern transaktion;

	private RechnungModulFassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		this.transaktion = transaktion;
		this.rechnungVerwalter = new RechnungVerwalter(persistenz);
		this.zahlungseingangVerwalter = new ZahlungseingangVerwalter(persistenz);
		this.rechnungModulLogik = new RechnungModulLogik(rechnungVerwalter,
				zahlungseingangVerwalter);
	}

	public static RechnungModulFassade startRechnungFassade(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (rechnungModulFassade == null)
			rechnungModulFassade = new RechnungModulFassade(persistenz,
					transaktion);
		return rechnungModulFassade;
	}

	/**
	 * Für JunitTest ONLY !!!
	 */
	RechnungModulFassade(RechnungModulLogik rechnungModulLogik,
			RechnungVerwalter rechnungVerwalter,
			ZahlungseingangVerwalter zahlungseingangVerwalter,
			ITransaktionIntern transaktion) {
		this.rechnungModulLogik = rechnungModulLogik;
		this.rechnungVerwalter = rechnungVerwalter;
		this.zahlungseingangVerwalter = zahlungseingangVerwalter;
		this.transaktion = transaktion;
	}

	@Override
	public IRechnung erzeugeRechnung(IAuftrag auftrag) {
		
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			IRechnung rechnung = rechnungVerwalter.erstelleRechnung(auftrag);

			if (myTransaction)
				transaktion.commitTransaction();

			return rechnung;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return null;
		}
	}

	@Override
	public IRechnung verbucheTeilZahlungseingang(int rechnungsNr,
			IZahlungseingang zahlungseingang) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			IRechnung rechnung = rechnungModulLogik
					.verbucheTeilZahlungseingang(rechnungsNr, zahlungseingang);

			if (myTransaction)
				transaktion.commitTransaction();

			return rechnung;

		} catch (Exception e) {
			transaktion.rollbackTransaction();
		}
		return null;
	}

	@Override
	public IZahlungseingang erzeugeZahlungsEingang(Date datum, int betragCent) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			IZahlungseingang zahlungseingang = zahlungseingangVerwalter
					.erstelleZahlungsEingang(datum, betragCent);

			if (myTransaction)
				transaktion.commitTransaction();

			if (zahlungseingang != null)
				return zahlungseingang;

		} catch (Exception e) {
			transaktion.rollbackTransaction();
		}
		return null;
	}
}
