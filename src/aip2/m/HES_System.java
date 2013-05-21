package aip2.m;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import aip2.m.AngebotAuftragModul.AngebotAuftragModul;
import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;
import aip2.m.InterfacesExtern.IHES_System;
import aip2.m.InterfacesExtern.IKundenModulExtern;
import aip2.m.InterfacesExtern.ILieferungModulExtern;
import aip2.m.InterfacesExtern.IProduktModulExtern;
import aip2.m.InterfacesExtern.IRechnungsModulExtern;
import aip2.m.KundenModul.KundenModul;
import aip2.m.LieferungsModul.LieferungModul;
import aip2.m.PersistenzModul.IPersistenzSessionIntern;
import aip2.m.PersistenzModul.Persistenz;
import aip2.m.ProduktModul.ProduktModul;
import aip2.m.RechnungsModul.RechnungModul;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.TransaktionModul.Transaktion;
import aip2.redundanz.IDispatcherMonitor;

/**
 * Startet das komplete System, erstellt alle Module und liefert die Externen
 * Interfaces auf Anfrage aus
 * 
 */
public final class HES_System extends UnicastRemoteObject implements IHES_System {
	private static final long serialVersionUID = 1L;
	private static final int ALIVE_MILLISECONDS = 5000;	
	
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

	public IAngebotAuftragModulExtern getIAngebotAuftragModulExtern() {
		return AngebotAuftragModul.getIAngebotAuftragModulExtern(null, null);
	}

	public IKundenModulExtern getIKundenModulExtern() {
		return KundenModul.getIKundenModulExtern(null, null);
	}

	public ILieferungModulExtern getILieferungModulExtern() {
		return LieferungModul.getILieferungModulExtern(null, null);
	}

	public IProduktModulExtern getIProduktModulExtern() {
		return ProduktModul.getIProduktModulExtern(null, null);
	}

	public IRechnungsModulExtern getIRechnungsModulExtern() {
		return RechnungModul.getIRechnungsModulExtern(null, null);
	}
	
	public static void main(final String[] args) throws RemoteException {
		if (args.length < 1) {
			System.err.println("Usage: HES_System DispatcherIP");
			System.exit(-1);
		}
		
		IHES_System sys = new HES_System();
		Registry rmiRegistry = LocateRegistry.getRegistry(args[0]);
		IDispatcherMonitor d = null;
		try {
			d = (IDispatcherMonitor) rmiRegistry.lookup(IDispatcherMonitor.NAME);
		} catch (NotBoundException e) {
			System.err.println("Dispatcher not running at "+args[0]+"!");
			System.exit(-1);
		}
		try {
			d.registerAtDispatcher(sys, InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e1) {
			System.err.println("Locahost unknown! (>°o°)>");
			System.exit(-1);
		}
		
		while(true) {
			d.iAmAlive(sys);
			try {
				Thread.sleep(ALIVE_MILLISECONDS);
			} catch (InterruptedException e) {
				// ignore
			}
		}
	}
}
