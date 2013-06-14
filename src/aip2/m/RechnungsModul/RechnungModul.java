package aip2.m.RechnungsModul;

import aip2.m.Adapter.BankAdapter;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Factory Klasse konfiguriert und liefert die Rechnungs aus und erstellt den BankAdapter
 * 
 */
public final class RechnungModul {

	private static RechnungModulFassade rechnungModulFassade;
	private static BankAdapter bankAdapter;

	private RechnungModul() {
	}

	/**
	 * Gibt die einzige RechnungModulfassade zurück. Nach dem ersten Aufruf
	 * werden die Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige RechnungModulfassae
	 */
	public static IRechnungsModulExtern getIRechnungsModulExtern(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}

	/**
	 * Gibt die einzige RechnungModulfassade zurück. Nach dem ersten Aufruf
	 * werden die Parameter persistenz und transaktion ignoriert
	 * 
	 * @param persistenz
	 * @param transaktion
	 * @return die einzige RechnungModulfassae
	 */
	public static IRechnungsModulIntern getIRechnungsModulIntern(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		return fassade(persistenz, transaktion);
	}
	
	public static BankAdapter getBankAdapter(){
		return bankAdapter;
	}
	
	private static RechnungModulFassade fassade(IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (rechnungModulFassade == null) {
			RechnungVerwalter rechnungVerwalter = new RechnungVerwalter(
					persistenz);
			ZahlungseingangVerwalter zahlungseingangVerwalter = new ZahlungseingangVerwalter(
					persistenz);
			RechnungModulLogik rechnungModulLogik = new RechnungModulLogik(
					rechnungVerwalter, zahlungseingangVerwalter);
			rechnungModulFassade = new RechnungModulFassade(rechnungModulLogik,
					rechnungVerwalter, zahlungseingangVerwalter, transaktion);
			bankAdapter = new BankAdapter(rechnungModulFassade);
		}
		return rechnungModulFassade;
	}
}