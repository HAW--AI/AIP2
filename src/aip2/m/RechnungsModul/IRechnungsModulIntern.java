package aip2.m.RechnungsModul;

import java.util.Date;

import aip2.m.AngebotAuftragModul.IAuftrag;

/**
 * Operationen des RechnungsModul für die HES interne Nutzung
 * 
 */
public interface IRechnungsModulIntern {

	/**
	 * Erzeugt eine Rechnung für diesen Auftrag
	 * 
	 * @param auftrag
	 * @return Rechnung
	 */
	IRechnung erzeugeRechnung(IAuftrag auftrag);

	/**
	 * Erzeugt eine Zahlungseingang und liefert ihn zurück
	 * 
	 * @param datum
	 * @param betragCent
	 * @return der Zahlungseingang
	 */
	IZahlungseingang erzeugeZahlungsEingangReturn(Date datum, int betragCent);

	/**
	 * Ordnet der Rechnung mit der Nr den Zahlungseingang zu ... plus gucke ob
	 * gesamtpreis gezahlt und wenn ja setze Rechung auf istBezahlt Status
	 * 
	 * @param rechnungsNr
	 * @param zahlungseingang
	 * @return die aktualisierte Rechnung
	 */
	IRechnung verbucheTeilZahlungseingang(int rechnungsNr,
			IZahlungseingang zahlungseingang);
}
