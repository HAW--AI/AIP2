package aip2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import aip2.m.IHES_System;
import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.redundanz.Dispatcher;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		IHES_System hes = Dispatcher.getRedundantesHES("localhost");
		
		
		ProduktTyp produkt;
		KundenTyp kunde;
		AngebotTyp angebot;
		while (true) {
			System.out.println("Press Enter to trigger some action");
			(new Scanner(System.in)).nextLine();

			produkt = hes.erstelleProdukt("HDD 1TB", 10000);
			System.out.println("Erstelle Produkt: " + produkt);
			
			kunde = hes.erstelleKunde("Hans", "Im Dorf");
			System.out.println("Erstelle Kunde: " + kunde);
			
			produkt = hes.sucheProdukt("HDD").get(0);
			Map<ProduktTyp, Integer> pMap = new HashMap<ProduktTyp, Integer>();
			pMap.put(produkt, 1000);
			
			angebot = hes.erstelleAngebot(kunde, new Date(), pMap, 1000000);
			System.out.println("Erstelle Angebot: " + angebot);
			
			System.out.println("Bezahlte Rechnungen: " + hes.sucheBezahlteRechnungen());
			
			AuftragTyp auftrag = hes.erstelleAuftrag(angebot);
			System.out.println("Erstelle Auftrag: "+auftrag);
			
			produkt = null;
			kunde = null;
			angebot = null;
		}
		
	}
}