package aip2.m.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aip2.externeSysteme.DLH;
import aip2.externeSysteme.HapSpar;
import aip2.m.HES_System;
import aip2.m.AngebotAuftragModul.AngebotTyp;
import aip2.m.AngebotAuftragModul.AuftragTyp;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.LieferungsModul.LieferungModul;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.RechnungsModul.RechnungModul;
import aip2.m.RechnungsModul.RechnungTyp;

public final class Szenario_SystemTest {

	private static HES_System hes;
	static Set<KundenTyp> kunden;
	static Set<ProduktTyp> produkte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hes = new HES_System();

		// Erstellung von Testdaten (2 Kunden und 2 Produkte)
		kunden = new HashSet<KundenTyp>();
		kunden.add(hes.getIKundenModulExtern().erstelleKunde("Meier, Peter",
				"Bla 12 Dorf"));
		kunden.add(hes.getIKundenModulExtern().erstelleKunde("Meier, Bert",
				"Hust 13 Dorf"));

		produkte = new HashSet<ProduktTyp>();
		produkte.add(hes.getIProduktModulExtern().erstelleProdukt("SSD 1337",
				10000));
		produkte.add(hes.getIProduktModulExtern().erstelleProdukt("SSD ABC",
				5000));
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		// Lösche Daten...
	}

	@Test
	public void test() {
		// Call Agent sucht den Kunden
		List<KundenTyp> kundenL = hes.getIKundenModulExtern().sucheKunden(
				"Meier");
		Set<KundenTyp> kundenS = new HashSet<KundenTyp>(kundenL);
		// assertTrue(kunden.equals(kundenS));
		for (KundenTyp kundenTyp : kunden) {
			assertTrue(kundenS.contains(kundenTyp));
		}

		// Call Agent sucht das Produkt
		List<ProduktTyp> produktL = hes.getIProduktModulExtern().sucheProdukt(
				"SSD");
		Set<ProduktTyp> produktS = new HashSet<ProduktTyp>(produktL);
		// assertTrue(produkte.equals(produktS));
		for (ProduktTyp produktTyp : produkte) {
			assertTrue(produktS.contains(produktTyp));
		}

		// Call Agent erstellt Angebot
		Map<ProduktTyp, Integer> pMap = new HashMap<ProduktTyp, Integer>();
		pMap.put(produktL.get(0), 1000);
		AngebotTyp angebot = hes.getIAngebotAuftragModulExtern()
				.erstelleAngebot(kundenL.get(0), new Date(), pMap, 1000000);
		assertTrue(angebot != null);

		// 2 Wochen später, Call Agent sucht wieder Kunden
		List<KundenTyp> kundenL2 = hes.getIKundenModulExtern().sucheKunden(
				"Meier");
		KundenTyp kunde = kundenL2.get(0);

		// Call Agent sucht das Angebot
		List<AngebotTyp> angebote = new ArrayList<AngebotTyp>();
		angebote.add(angebot);
		List<AngebotTyp> angebotsListe = hes.getIAngebotAuftragModulExtern()
				.sucheAngebote(kunde);
		// assertTrue(angebote.equals(angebotsListe));

		for (AngebotTyp angebotTyp : angebote) {
			assert (angebotsListe.contains(angebotTyp));
		}
		AngebotTyp angenommenesAngebot = angebote.get(0);

		// Call Agent erstellt Auftrag
		AuftragTyp auftrag = hes.getIAngebotAuftragModulExtern()
				.erstelleAuftrag(angenommenesAngebot);
		assertTrue(auftrag != null);
		assertFalse(auftrag.isAbgeschlossen());
		assertEquals(angenommenesAngebot.getAngebotsNr(),
				auftrag.getAngebotsNr());

		// EXTERNE SCHRITTE
		// Lieferung wird abgeliefert
		DLH.lieferantHatAbgeliefertNr(auftrag.getLieferungsNr());
		// Begleiche Rechnung
		HapSpar.ueberweise(auftrag.getRechnungsNr(), new int[] { 1000000 });
		// ENDE EXTERNE SCHRITTE

		// Adapter BatchJobs
		// Hole Lieferungen
		LieferungModul.getTransportdienstleisterAdapter().jedeNacht();
		// Rechnungen begleichen
		RechnungModul.getBankAdapter().jedeNacht();

		// Buchhaltung dursucht alle bezahlten Rechnungen
		List<RechnungTyp> bezahlteRechnungen = hes.getIRechnungsModulExtern()
				.sucheBezahlteRechnungen();
		RechnungTyp auftragsRechnung = null;
		for (RechnungTyp rechnungTyp : bezahlteRechnungen) {
			if (rechnungTyp.getAuftragNr() == auftrag.getAuftragsNr())
				auftragsRechnung = rechnungTyp;
		}
		assertTrue(auftragsRechnung != null);
		assertTrue(auftragsRechnung.getAuftragNr() == auftrag.getAuftragsNr());
		assertTrue(auftragsRechnung.isIstBezahlt());

		// Buchhaltung sucht den zur Rechnung gehörenden Auftrag
		List<AuftragTyp> buchhaltungsAuftrage = hes
				.getIAngebotAuftragModulExtern().sucheAuftraege(
						auftragsRechnung.getAuftragNr());
		assertTrue(buchhaltungsAuftrage.size() == 1);

		AuftragTyp buchhaltungsAuftrag = buchhaltungsAuftrage.get(0);
		assertTrue(buchhaltungsAuftrag.getAuftragsNr() == auftrag
				.getAuftragsNr());

		// Buchhaltung markiert Auftrag als abgeschlossen
		boolean abSchluss = hes.getIAngebotAuftragModulExtern()
				.schliesseAbAuftrag(buchhaltungsAuftrag);
		assertTrue(abSchluss);

		// ALLES Erledigt Auftrag abgeschlossen

		List<AuftragTyp> kontrolleAuftrage = hes
				.getIAngebotAuftragModulExtern().sucheAuftraege(
						buchhaltungsAuftrag.getAuftragsNr());
		assertTrue(kontrolleAuftrage.size() == 1);
		AuftragTyp finalAuftrag = kontrolleAuftrage.get(0);
		assertTrue(finalAuftrag.isAbgeschlossen());
	}
}
