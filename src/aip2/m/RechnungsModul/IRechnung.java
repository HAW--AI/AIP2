package aip2.m.RechnungsModul;

import java.util.Date;
import java.util.Set;

import aip2.m.AngebotAuftragModul.IAuftrag;

public interface IRechnung {

	int getRechnungsNr();

	Date getRechnungsDatum();

	boolean isIstBezahlt();

	IAuftrag getAuftrag();

	Set<Zahlungseingang> getZahlungseingaenge();

}