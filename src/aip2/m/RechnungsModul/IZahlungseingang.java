package aip2.m.RechnungsModul;

import java.util.Date;

public interface IZahlungseingang {

	int getZahlungseingangNr();

	Date getEingangsDatum();

	int getBetragCent();

	IRechnung getRechnung();

}