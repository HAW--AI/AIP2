package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.ProduktModul.IProdukt;

public interface IWarenausgangsmeldung {

	int getWarenausgangsmeldungNr();

	Date getDatum();

	int getMenge();

	IProdukt getProdukt();

}