package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.ProduktModul.IProdukt;

final class WarenmeldungsVerwalter {
	private final IPersistenzIntern persistenz;

	WarenmeldungsVerwalter(IPersistenzIntern persistenz) {
		this.persistenz = persistenz;
	}

	IWarenausgangsmeldung erstelleWarenausgangsmeldung(Date datum, int menge, IProdukt produkt) {
		IWarenausgangsmeldung m = new Warenausgangsmeldung(datum, menge, produkt);
		persistenz.add(m);
		return m;
	}
	
	IWareneingangsmeldung erstelleWareneingangsmeldung(Date datum, int menge, String lieferschein, IBestellung bestellung) {
		IWareneingangsmeldung m = new Wareneingangsmeldung(datum, menge, lieferschein, bestellung);
		persistenz.add(m);
		return m;
	}
}
