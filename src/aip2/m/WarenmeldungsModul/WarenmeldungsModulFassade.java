package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;
import aip2.m.ProduktModul.IProdukt;
import aip2.m.TransaktionModul.ITransaktionIntern;

public class WarenmeldungsModulFassade implements IWarenmeldungsModulIntern {

	private final WarenmeldungsModulLogik warenmeldungsModulLogik;
	@SuppressWarnings("unused")
	private final WarenmeldungsVerwalter warenmeldungsVerwalter;
	private final ITransaktionIntern transaktion;
	
	WarenmeldungsModulFassade(WarenmeldungsModulLogik warenmeldungsModulLogik, WarenmeldungsVerwalter warenmeldungsVerwalter,
			ITransaktionIntern transaktion) {
		this.warenmeldungsModulLogik = warenmeldungsModulLogik;
		this.warenmeldungsVerwalter = warenmeldungsVerwalter;
		this.transaktion = transaktion;
	}
	
	@Override
	public IWarenausgangsmeldung erstelleWarenausgangsmeldung(Date datum, int menge, IProdukt produkt) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();
			IWarenausgangsmeldung w = warenmeldungsModulLogik.erstelleWarenausgangsmeldung(datum, menge, produkt);
			if (myTransaction) transaktion.commitTransaction();
			return w;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return null;
		}
	}

	@Override
	public IWareneingangsmeldung erstelleWareneingangsmeldung(Date datum, int menge, String lieferschein, IBestellung bestellung) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();
			IWareneingangsmeldung w = warenmeldungsModulLogik.erstelleWareneingangsmeldung(datum, menge, lieferschein, bestellung);
			if (myTransaction) transaktion.commitTransaction();
			return w;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return null;
		}
	}

}
