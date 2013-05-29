package aip2.redundanz;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.List;
import java.util.Map;

import aip2.m.IHES_System;
import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.RechnungsModul.RechnungTyp;

public class Dispatcher implements IHES_System {
	private static Dispatcher dispatcher = null;

	private IMonitorRR monitor;

	public Dispatcher(String monitorHost) {
		
		Registry rmiRegistry;
		try {
			rmiRegistry = LocateRegistry.getRegistry(monitorHost);
		
		IMonitorRR d = null;
		try {
			d = (IMonitorRR) rmiRegistry.lookup(IMonitorRR.NAME);
			this.monitor = d;
		} catch (NotBoundException e) {
			System.err.println("Monitor not running at "+monitorHost+"!");
			System.exit(-1);
		}
		} catch (RemoteException e1) {
			System.err.println("Monitor not running atAll "+monitorHost+"!");
			System.exit(-1);
		}	
	}

	private IHES_System getHES() throws RemoteException{
		return monitor.getCurrentHES();
	}

	@Override
	public AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<ProduktTyp, Integer> anzahlProdukte, int preisCent)
			throws RemoteException {
		return getHES().erstelleAngebot(kunde, angebotsEnde, anzahlProdukte,
				preisCent);
	}

	@Override
	public List<AngebotTyp> sucheAngebote(KundenTyp kunde)
			throws RemoteException {
		return getHES().sucheAngebote(kunde);
	}

	@Override
	public AuftragTyp erstelleAuftrag(AngebotTyp angebot)
			throws RemoteException {
		return getHES().erstelleAuftrag(angebot);
	}

	@Override
	public List<AuftragTyp> sucheAuftraege(int RechnungsNr)
			throws RemoteException {
		return getHES().sucheAuftraege(RechnungsNr);
	}

	@Override
	public boolean schliesseAbAuftrag(AuftragTyp auftrag)
			throws RemoteException {
		return getHES().schliesseAbAuftrag(auftrag);
	}

	@Override
	public List<KundenTyp> sucheKunden(String name) throws RemoteException {
		return getHES().sucheKunden(name);
	}

	@Override
	public KundenTyp sucheKunden(int kundenId) throws RemoteException {
		return getHES().sucheKunden(kundenId);
	}

	@Override
	public KundenTyp erstelleKunde(String name, String adresse)
			throws RemoteException {
		return getHES().erstelleKunde(name, adresse);
	}

	@Override
	public boolean bestaetigeLieferung(int lieferungsNummer)
			throws RemoteException {
		return getHES().bestaetigeLieferung(lieferungsNummer);
	}

	@Override
	public List<ProduktTyp> sucheProdukt(String name) throws RemoteException {
		return getHES().sucheProdukt(name);
	}

	@Override
	public ProduktTyp sucheProdukt(int id) throws RemoteException {
		return getHES().sucheProdukt(id);
	}

	@Override
	public ProduktTyp erstelleProdukt(String name, int mengeImLager)
			throws RemoteException {
		return getHES().erstelleProdukt(name, mengeImLager);
	}

	@Override
	public boolean erzeugeZahlungsEingang(Date datum, int betragCent)
			throws RemoteException {
		return getHES().erzeugeZahlungsEingang(datum, betragCent);
	}

	@Override
	public boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr,
			Date datum, int betragCent) throws RemoteException {
		return getHES().erzeugeZahlungsEingangUndVerbuche(rechnungsNr, datum,
				betragCent);
	}

	@Override
	public List<RechnungTyp> sucheBezahlteRechnungen() throws RemoteException {
		return getHES().sucheBezahlteRechnungen();
	}

	public static IHES_System getRedundantesHES(String host) {
		if (Dispatcher.dispatcher == null) {
//			try {
//				final Monitor m = new Monitor();
//				new Thread() {
//					public void run() {
//						m.run();
//					}
//				}.start();

				Dispatcher.dispatcher = new Dispatcher(host);
//			} catch (RemoteException e) {
//				e.printStackTrace();
//				return null;
//			}
		}
		return Dispatcher.dispatcher;
	}

//	public static void main(String[] args) throws RemoteException {
//		getRedundantesHES();
		// final Monitor m = new Monitor();
		// new Thread() {
		// public void run() {
		// m.run();
		// }
		// }.start();
		//
		// Dispatcher p = new Dispatcher(m);
		// System.out.println("Dispatcher & Monitor are running...");

		// while (true) {
		// (new Scanner(System.in)).nextLine();
		// p.erstelleProdukt("HDD 1TB", 10000);
		// p.erstelleKunde("Hans", "Im Dorf");
		// }
//	}
}
