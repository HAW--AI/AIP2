package aip2.m.RechnungsModul;

import aip2.m.AngebotAuftragModul.IAuftrag;

public interface IRechnungsModulIntern {
	
	IRechnung erzeugeRechnung(IAuftrag auftrag);
	
	/**
	 * ... plus gucke ob gesamtpreis gezahlt
	 * @param rechnungsNr
	 * @param zahlungseingang
	 * @return
	 */
	IRechnung verbucheTeilZahlungseingang(int rechnungsNr, IZahlungseingang zahlungseingang);
}
