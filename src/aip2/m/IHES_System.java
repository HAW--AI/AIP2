package aip2.m;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.RechnungsModul.RechnungTyp;

public interface IHES_System extends Remote {
	public AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<ProduktTyp, Integer> anzahlProdukte, int preisCent) throws RemoteException;

	public List<AngebotTyp> sucheAngebote(KundenTyp kunde) throws RemoteException;

	public AuftragTyp erstelleAuftrag(AngebotTyp angebot) throws RemoteException;

	public List<AuftragTyp> sucheAuftraege(int RechnungsNr) throws RemoteException;

	public boolean schliesseAbAuftrag(AuftragTyp auftrag) throws RemoteException;

	public List<KundenTyp> sucheKunden(String name) throws RemoteException;

	public KundenTyp sucheKunden(int kundenId) throws RemoteException;

	public KundenTyp erstelleKunde(String name, String adresse) throws RemoteException;

	public boolean bestaetigeLieferung(int lieferungsNummer) throws RemoteException;

	public List<ProduktTyp> sucheProdukt(String name) throws RemoteException;

	public ProduktTyp sucheProdukt(int id) throws RemoteException;

	public ProduktTyp erstelleProdukt(String name, int mengeImLager) throws RemoteException;

	public boolean erzeugeZahlungsEingang(Date datum, int betragCent) throws RemoteException;

	public boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr,
			Date datum, int betragCent) throws RemoteException;

	public List<RechnungTyp> sucheBezahlteRechnungen() throws RemoteException;
}
