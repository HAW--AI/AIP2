package aip2.m.InterfacesExtern;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.ProduktTyp;

/**
 * Stellt Methoden des AngebotAuftragModul für externe Benutzer bereit
 * 
 */
public interface IAngebotAuftragModulExtern extends Remote {

	/**
	 * Erstellt ein Angebot
	 * 
	 * @param Kunde
	 * @param Datum
	 *            des angebotsEnde
	 * @param Eine
	 *            Map die die gewünschten Produkte auf die gewünschte Menge
	 *            abbildet
	 * @param Gesamtpreis
	 *            in Cent
	 * @return Das Angebot als fachlicher DatenTyp oder null bei Misserfolg
	 */
	AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<ProduktTyp, Integer> anzahlProdukte, int preisCent) throws RemoteException;

	/**
	 * Sucht alle jemals erstellten Angebote die einem Kunden gemacht wurden
	 * 
	 * @param kunde
	 * @return Eine leere List, falls keine vorhanden sind, sonst eine Liste von
	 *         Angboten
	 */
	List<AngebotTyp> sucheAngebote(KundenTyp kunde) throws RemoteException;

	/**
	 * Erstelle aus einem Angebot eine Auftag
	 * 
	 * @param angebot
	 * @return Der Auftrag als fachlicher DatenTyp oder null bei Misserfolg
	 */
	AuftragTyp erstelleAuftrag(AngebotTyp angebot) throws RemoteException;

	/**
	 * Sucht alle Auftrage die dieser Rechnungsnr zugeordnet sind
	 * 
	 * @param RechnungsNr
	 * @return Eine leere List, falls keine vorhanden sind, sonst eine Liste von
	 *         Angboten meistens der Länge 1
	 */
	List<AuftragTyp> sucheAuftraege(int RechnungsNr) throws RemoteException;

	/**
	 * Markiert einen Auftrag als abgeschlossen
	 * 
	 * @param auftrag
	 * @return Der ErfolgsStatus der Operation
	 */
	boolean schliesseAbAuftrag(AuftragTyp auftrag) throws RemoteException;

}
