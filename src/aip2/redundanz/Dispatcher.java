package aip2.redundanz;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.InterfacesExtern.IHES_System;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.RechnungsModul.RechnungTyp;

public class Dispatcher implements IHES_SystemExtern {
	private Monitor monitor;
	
	public Dispatcher(Monitor monitor) {
		this.monitor = monitor;
	}
	
	private IHES_System getHES() {
		return monitor.getCurrentHES();
	}
	
	@Override
	public AngebotTyp erstelleAngebot(KundenTyp kunde, Date angebotsEnde,
			Map<ProduktTyp, Integer> anzahlProdukte, int preisCent) throws RemoteException {
		return getHES().erstelleAngebot(kunde, angebotsEnde, anzahlProdukte, preisCent);
	}

	@Override
	public List<AngebotTyp> sucheAngebote(KundenTyp kunde) throws RemoteException {
		return getHES().sucheAngebote(kunde);
	}

	@Override
	public AuftragTyp erstelleAuftrag(AngebotTyp angebot) throws RemoteException {
		return getHES().erstelleAuftrag(angebot);
	}

	@Override
	public List<AuftragTyp> sucheAuftraege(int RechnungsNr) throws RemoteException {
		return getHES().sucheAuftraege(RechnungsNr);
	}

	@Override
	public boolean schliesseAbAuftrag(AuftragTyp auftrag) throws RemoteException {
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
	public KundenTyp erstelleKunde(String name, String adresse) throws RemoteException {
		return getHES().erstelleKunde(name, adresse);
	}

	@Override
	public boolean bestaetigeLieferung(int lieferungsNummer) throws RemoteException {
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
	public ProduktTyp erstelleProdukt(String name, int mengeImLager) throws RemoteException {
		return getHES().erstelleProdukt(name, mengeImLager);
	}

	@Override
	public boolean erzeugeZahlungsEingang(Date datum, int betragCent) throws RemoteException {
		return getHES().erzeugeZahlungsEingang(datum, betragCent);
	}

	@Override
	public boolean erzeugeZahlungsEingangUndVerbuche(int rechnungsNr,
			Date datum, int betragCent) throws RemoteException {
		return getHES().erzeugeZahlungsEingangUndVerbuche(rechnungsNr, datum, betragCent);
	}

	@Override
	public List<RechnungTyp> sucheBezahlteRechnungen() throws RemoteException {
		return getHES().sucheBezahlteRechnungen();
	}

	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws RemoteException {
		final Monitor m = new Monitor();
		new Thread() {
			public void run(){
			m.run();
			}
		}.start();
		
		System.out.println("Wait...");
		(new Scanner(System.in)).nextLine();
		
		Dispatcher p = new Dispatcher(m);
		p.bestaetigeLieferung(0);
	}
}
