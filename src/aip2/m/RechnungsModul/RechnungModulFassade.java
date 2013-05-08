package aip2.m.RechnungsModul;

import java.util.Date;

import aip2.m.AngebotAuftragModul.IAuftrag;

import aip2.m.InterfacesExtern.IRechnungsModulExtern;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Stellt die Schnittstelle für externe Operationen und steuert Transaktionen
 * 
 */
final class RechnungModulFassade implements IRechnungsModulIntern,
		IRechnungsModulExtern {

	private final RechnungModulLogik rechnungModulLogik;
	private final RechnungVerwalter rechnungVerwalter;
	private final ZahlungseingangVerwalter zahlungseingangVerwalter;
	private final ITransaktionIntern transaktion;

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
	public boolean erzeugeZahlungsEingang(Date datum, int betragCent) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			IZahlungseingang zahlungseingang = zahlungseingangVerwalter
					.erstelleZahlungsEingang(datum, betragCent);

			if (myTransaction)
				transaktion.commitTransaction();

			if (zahlungseingang != null)
				return true;

		} catch (Exception e) {
			transaktion.rollbackTransaction();
		}
		return false;
	}

//	@Override
//	public IZahlungseingang erzeugeZahlungsEingangReturn(Date datum,
//			int betragCent) {
//		try {
//			boolean myTransaction = transaktion.checkStartMyTransaction();
//
//			IZahlungseingang zahlungseingang = zahlungseingangVerwalter
//					.erstelleZahlungsEingang(datum, betragCent);
//
//			if (myTransaction)
//				transaktion.commitTransaction();
//
//			if (zahlungseingang != null)
//				return zahlungseingang;
//
//		} catch (Exception e) {
//			transaktion.rollbackTransaction();
//		}
//		return null;
//	}

	@Override
	public boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr,
			Date datum, int betragCent) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			IZahlungseingang zahlungseingang = zahlungseingangVerwalter
					.erstelleZahlungsEingang(datum, betragCent);
			IRechnung rechnung = rechnungModulLogik
					.verbucheTeilZahlungseingang(rechnungsNr, zahlungseingang);

			System.out.println(zahlungseingang);
			System.out.println(rechnung);
			if (myTransaction)
				transaktion.commitTransaction();

			if (rechnung != null)
				return true;

		} catch (Exception e) {
			transaktion.rollbackTransaction();
		}
		return false;
	}
}
