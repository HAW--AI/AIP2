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
import aip2.m.PersistenzModul.Persistenz;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.TransaktionModul.Transaktion;

public final class Szenario_SystemTest {

	private static ITransaktionIntern transaktionIntern;

	private static HES_System hes;
	static Set<KundenTyp> kunden;
	static Set<ProduktTyp> produkte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hes = new HES_System();
	}

	@Before
	public void setUp() throws Exception {
		transaktionIntern = Transaktion.getTransaktion(Persistenz
				.getPersistenzSessionIntern());
		transaktionIntern.checkStartMyTransaction();

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

	@After
	public void tearDown() throws Exception {
		// Lösche Daten...
		// transaktionIntern.commitTransaction();
		transaktionIntern.rollbackTransaction();
	}

	@Test
	public void test() {
		// Call Agent sucht den Kunden
		List<KundenTyp> kundenL = hes.getIKundenModulExtern().sucheKunden(
				"Meier");
		Set<KundenTyp> kundenS = new HashSet<KundenTyp>(kundenL);
		assertTrue(kunden.equals(kundenS));

		// Call Agent sucht das Produkt
		List<ProduktTyp> produktL = hes.getIProduktModulExtern().sucheProdukt(
				"SSD");
		Set<ProduktTyp> produktS = new HashSet<ProduktTyp>(produktL);
		assertTrue(produkte.equals(produktS));

		// Call Agent erstellt Angebot
		Map<ProduktTyp, Integer> pMap = new HashMap<ProduktTyp, Integer>();
		pMap.put(produktL.get(0), 1000);
		AngebotTyp angebot = hes.getIAngebotAuftragModulExtern()
				.erstelleAngebot(kundenL.get(0), new Date(), pMap, 1000000);
		assertTrue(angebot != null);

		// Call Agent sucht wieder Kunden

		// Call Agent sucht das Angebot
		List<AngebotTyp> angebote = new ArrayList<AngebotTyp>();
		angebote.add(angebot);
		List<AngebotTyp> angebotsListe = hes.getIAngebotAuftragModulExtern()
				.sucheAngebote(kundenL.get(0));
		assertTrue(angebote.equals(angebotsListe));

		// Call Agent erstellt Auftrag
		AuftragTyp auftrag = hes.getIAngebotAuftragModulExtern()
				.erstelleAuftrag(angebot);
		assertTrue(auftrag != null);

		// EXTERNE SCHRITTE
		// Lieferung wird abgeliefert
		DLH.lieferantHatAbgeliefertNr(auftrag.getLieferungsNr());
		// Begleiche Rechnung
		HapSpar.ueberweise(auftrag.getRechnungsNr(), new int[] { 1000000 });
		// ENDE EXTERNE SCHRITTE

		// Hole Lieferungen
		LieferungModul.getTransportdienstleisterAdapter().jedeNacht();
		// TODO Rechnungen begleichen
		// RechnungModul.getBankAdapter().jedeNacht();

		System.out.println(auftrag);

		// Tests um zu prüfen, ob das tatsächlich in der DB ist (?)
	}

}
