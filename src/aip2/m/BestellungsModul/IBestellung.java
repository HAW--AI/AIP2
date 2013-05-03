package aip2.m.BestellungsModul;

import java.util.Date;

import aip2.m.LieferantenModul.ILieferant;
import aip2.m.ProduktModul.IProdukt;
import aip2.m.WarenmeldungsModul.IWareneingangsmeldung;

public interface IBestellung {

	int getBestellNr();

	Date getBestelldatum();

	int getMenge();

	boolean isFreigabe();

	IProdukt getProdukt();

	IWareneingangsmeldung getWareneingangsmeldung();

	ILieferant getLieferant();

}