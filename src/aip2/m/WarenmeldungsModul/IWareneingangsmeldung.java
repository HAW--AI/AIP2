package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;

public interface IWareneingangsmeldung {

	int getWareneingangsmeldungNr();

	Date getDatum();

	int getMenge();
	
	String getLieferschein();

	IBestellung getBestellung();

}