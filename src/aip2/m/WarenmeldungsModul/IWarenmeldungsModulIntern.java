package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;
import aip2.m.ProduktModul.IProdukt;

public interface IWarenmeldungsModulIntern {

	IWarenausgangsmeldung erstelleWarenausgangsmeldung(Date datum, int menge, IProdukt produkt);
	
	IWareneingangsmeldung erstelleWareneingangsmeldung(Date datum, int menge, String lieferschein, IBestellung bestellung);
}
