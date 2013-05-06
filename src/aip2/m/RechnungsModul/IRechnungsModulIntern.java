package aip2.m.RechnungsModul;

import java.util.Date;

import aip2.m.AngebotAuftragModul.IAuftrag;

public interface IRechnungsModulIntern {
	
	IRechnung erzeugeRechnung(IAuftrag auftrag);
	
	IZahlungseingang erzeugeZahlungsEingang(Date datum, int betragCent);
	
	/**
	 * ... plus gucke ob gesamtpreis gezahlt
	 * @param rechnungsNr
	 * @param zahlungseingang
	 * @return
	 */
	IRechnung verbucheTeilZahlungseingang(int rechnungsNr, IZahlungseingang zahlungseingang);
}
