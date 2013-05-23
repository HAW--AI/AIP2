package aip2.m;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.AngebotAuftragModul.AngebotAuftragModul;
import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;
import aip2.m.InterfacesExtern.IHES_System;
import aip2.m.InterfacesExtern.IKundenModulExtern;
import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.InterfacesExtern.IProduktModulExtern;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;
import aip2.m.KundenModul.KundenModul;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.LieferungsModul.LieferungModul;
import aip2.m.PersistenzModul.IPersistenzSessionIntern;
import aip2.m.PersistenzModul.Persistenz;
import aip2.m.ProduktModul.ProduktModul;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.RechnungsModul.RechnungModul;
import aip2.m.RechnungsModul.RechnungTyp;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.TransaktionModul.Transaktion;
import aip2.redundanz.IMonitor;

/**
 * Startet das komplete System, erstellt alle Module und liefert die Externen
 * Interfaces auf Anfrage aus
 * 
 */
public final class HES_System extends UnicastRemoteObject implements IHES_System {
	private static final long serialVersionUID = 1L;
	private static final int ALIVE_MILLISECONDS = 1000;	
	
	// Erstellung der einzelnen Modul
	public HES_System() throws RemoteException {
		IPersistenzSessionIntern persistenzSession = Persistenz
				.getPersistenzSessionIntern();
		ITransaktionIntern transaktion = Transaktion
				.getTransaktion(persistenzSession);

		/*
		 * Erstellung durch das AAModul -> kaskadische Erstellung aller anderen
		 * Module
		 * 
		 * AAModul -> KundenModul -> LieferungModul -> RechnungModul ->
		 * ProduktModul -> WarenmeldungsModul
		 */
		AngebotAuftragModul.getIAngebotAuftragModulExtern(persistenzSession,
				transaktion);
	}

	private IAngebotAuftragModulExtern getIAA() {
		return AngebotAuftragModul.getIAngebotAuftragModulExtern(null, null);
	}

	private IKundenModulExtern getIKM() {
		return KundenModul.getIKundenModulExtern(null, null);
	}

	private ILieferungModulExtern getILM() {
		return LieferungModul.getILieferungModulExtern(null, null);
	}

	private IProduktModulExtern getIPM() {
		return ProduktModul.getIProduktModulExtern(null, null);
	}

	private IRechnungsModulExtern getIRM() {
		return RechnungModul.getIRechnungsModulExtern(null, null);
	}
	
	public static void main(final String[] args) throws RemoteException {
		if (args.length < 2) {
			System.err.println("Usage: HES_System HESName MonitorIP");
			System.exit(-1);
		}
		
		HES_System sys = new HES_System();
		sys.connectAndRun(args[0], args[1]);
	}

	/**
	 * 
	 * @param name MUSS EINDEUTIG SEIN!
	 * @param hostname
	 * @throws RemoteException
	 */
	public void connectAndRun(String name, String hostname) throws RemoteException {
		Registry rmiRegistry = LocateRegistry.getRegistry(hostname);
		IMonitor d = null;
		try {
			d = (IMonitor) rmiRegistry.lookup(IMonitor.NAME);
		} catch (NotBoundException e) {
			System.err.println("Monitor not running at "+hostname+"!");
			System.exit(-1);
		}
		try {
			boolean res = d.registerAtMonitor(this, name, InetAddress.getLocalHost().getHostName());
			if (!res) {
				System.err.println("Could not register at monitor!");
				System.exit(-1);
			}
		} catch (UnknownHostException e1) {
			System.err.println("Locahost unknown! (>°o°)>");
			System.exit(-1);
		}
		
		while(true) {
			try {
				d.iAmAlive(name);
			} catch (RemoteException e) {
				System.err.println("Monitor is down! Exit...");
				System.exit(-1);
			}
			
			try {
				Thread.sleep(ALIVE_MILLISECONDS);
			} catch (InterruptedException e) {
				// ignore
			}
		}
	}
	
	@Override
	public AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<ProduktTyp, Integer> anzahlProdukte, int preisCent) throws RemoteException {
		return getIAA().erstelleAngebot(kunde, angebotsEnde, anzahlProdukte, preisCent);
	}

	@Override
	public List<AngebotTyp> sucheAngebote(KundenTyp kunde) {
		return getIAA().sucheAngebote(kunde);
	}

	@Override
	public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
		return getIAA().erstelleAuftrag(angebot);
	}

	@Override
	public List<AuftragTyp> sucheAuftraege(int RechnungsNr) {
		return getIAA().sucheAuftraege(RechnungsNr);
	}

	@Override
	public boolean schliesseAbAuftrag(AuftragTyp auftrag) {
		return getIAA().schliesseAbAuftrag(auftrag);
	}

	@Override
	public List<KundenTyp> sucheKunden(String name) {
		return getIKM().sucheKunden(name);
	}

	@Override
	public KundenTyp sucheKunden(int kundenId) {
		return getIKM().sucheKunden(kundenId);
	}

	@Override
	public KundenTyp erstelleKunde(String name, String adresse) {
		return getIKM().erstelleKunde(name, adresse);
	}

	@Override
	public boolean bestaetigeLieferung(int lieferungsNummer) {
		return getILM().bestaetigeLieferung(lieferungsNummer);
	}

	@Override
	public List<ProduktTyp> sucheProdukt(String name) {
		return getIPM().sucheProdukt(name);
	}

	@Override
	public ProduktTyp sucheProdukt(int id) {
		return getIPM().sucheProdukt(id);
	}

	@Override
	public ProduktTyp erstelleProdukt(String name, int mengeImLager) {
		return getIPM().erstelleProdukt(name, mengeImLager);
	}

	@Override
	public boolean erzeugeZahlungsEingang(Date datum, int betragCent) {
		return getIRM().erzeugeZahlungsEingang(datum, betragCent);
	}

	@Override
	public boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr,
			Date datum, int betragCent) {
		return getIRM().erzeugeZahlungsEingangUndVerbuche(rechnungsNr, datum, betragCent);
	}

	@Override
	public List<RechnungTyp> sucheBezahlteRechnungen() {
		return getIRM().sucheBezahlteRechnungen();
	}
}
