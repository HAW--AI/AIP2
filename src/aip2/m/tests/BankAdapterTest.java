package aip2.m.tests;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import aip2.externeSysteme.HapSpar;
import aip2.m.HES_System;
import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.RechnungsModul.RechnungTyp;

public class BankAdapterTest {

	private static HES_System hes;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hes = new HES_System();
	}

	@Test
	public void test() throws RemoteException {

		//Erstelle Kunden Produkt Angebot und Auftrag
		KundenTyp kunde = hes.erstelleKunde("Meier, Peter", "Bla 12 Dorf");
		ProduktTyp produkt = hes.erstelleProdukt("SSD 1337", 10000);
		
		Map<ProduktTyp, Integer> pMap = new HashMap<ProduktTyp, Integer>();
		pMap.put(produkt, 1000);
		
		AngebotTyp angebot = hes.erstelleAngebot(kunde, new Date(), pMap,
				1000000);
		AuftragTyp auftrag = hes.erstelleAuftrag(angebot);

		
		//HAPSPAR Zahlungen 
		HapSpar.main(new String[] { "" + auftrag.getRechnungsNr(), "" + 500000 });
		HapSpar.main(new String[] { "" + auftrag.getRechnungsNr(), "" + 500000 });

		
		//Suche die Rechnung zum Auftrag
		List<RechnungTyp> bezahlteRechnungen = hes.sucheBezahlteRechnungen();
		RechnungTyp auftragsRechnung = null;
		for (RechnungTyp rechnungTyp : bezahlteRechnungen) {
			if (rechnungTyp.getAuftragNr() == auftrag.getAuftragsNr())
				auftragsRechnung = rechnungTyp;
		}
		assertTrue(auftragsRechnung != null);
		assertTrue(auftragsRechnung.getAuftragNr() == auftrag.getAuftragsNr());
		//Auftrag ist bezahlt
		assertTrue(auftragsRechnung.isIstBezahlt());

	}

}
