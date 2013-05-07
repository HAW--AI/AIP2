package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;
import aip2.m.ProduktModul.IProdukt;

public class WarenmeldungsModulLogik {
	private final WarenmeldungsVerwalter warenmeldungsVerwalter;

	WarenmeldungsModulLogik(WarenmeldungsVerwalter warenmeldungsVerwalter) {
		this.warenmeldungsVerwalter = warenmeldungsVerwalter;
	}	
	
	IWarenausgangsmeldung erstelleWarenausgangsmeldung(Date datum, int menge, IProdukt produkt) {
		return warenmeldungsVerwalter.erstelleWarenausgangsmeldung(datum, menge, produkt);
	}
	
	IWareneingangsmeldung erstelleWareneingangsmeldung(Date datum, int menge, String lieferschein, IBestellung bestellung) {
		return warenmeldungsVerwalter.erstelleWareneingangsmeldung(datum, menge, lieferschein, bestellung);
	}
}
