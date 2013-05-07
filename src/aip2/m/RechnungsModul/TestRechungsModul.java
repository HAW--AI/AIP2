package aip2.m.RechnungsModul;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import aip2.m.PersistenzModul.IPersistenzSessionIntern;
import aip2.m.PersistenzModul.Persistenz;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.TransaktionModul.Transaktion;

public class TestRechungsModul {

	private static IPersistenzSessionIntern persistenzSession;
	private static ITransaktionIntern transaktion;

	private static RechnungModulLogik rechnungModulLogik;
	private static RechnungVerwalter rechnungVerwalter;
	private static ZahlungseingangVerwalter zahlungseingangVerwalter;
	private static RechnungModulFassade rechnungModulFassade;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		persistenzSession = Persistenz.getPersistenzSessionIntern();
		transaktion = Transaktion.getTransaktion(persistenzSession);

		rechnungVerwalter = new RechnungVerwalter(persistenzSession);
		zahlungseingangVerwalter = new ZahlungseingangVerwalter(
				persistenzSession);
		rechnungModulLogik = new RechnungModulLogik(rechnungVerwalter,
				zahlungseingangVerwalter);
		rechnungModulFassade = new RechnungModulFassade(rechnungModulLogik,
				rechnungVerwalter, zahlungseingangVerwalter, transaktion);

	}

	@Before
	public void setUp() throws Exception {
		transaktion.startTransaction();

	}

	@After
	public void tearDown() throws Exception {
		transaktion.commitTransaction();

	}

	@Test
	public void testIRechnungsModulExtern() {
		// TODO teste IRechnungExtern
		rechnungModulFassade.erzeugeZahlungsEingang(new Date(), 100);

		List<Zahlungseingang> list = persistenzSession
				.getAll(Zahlungseingang.class);
		assertTrue(list.size() > 0);
	}

	@Ignore
	public void testIRechnungsModulIntern() {

		// TODO test IRechnungIntern
		// IAngebot angebot = new MyAngebotMockUp(90);
		// IAuftrag auftrag = new MyAuftragMockUp(0, false, angebot);

		// IRechnung rechnung = rechnungModulFassade.erzeugeRechnung(auftrag);
		// System.out.println(rechnung);

	}

	// private class MyAuftragMockUp implements IAuftrag {
	// int nr;
	// boolean abgeschlossen;
	// IRechnung rechnung;
	// IAngebot angebot;
	//
	// protected MyAuftragMockUp(int nr, boolean abgeschlossen,
	// IAngebot angebot) {
	// this.nr = nr;
	// this.abgeschlossen = abgeschlossen;
	// this.angebot = angebot;
	// }
	//
	// @Override
	// public int getAuftragsNr() {
	// return nr;
	// }
	//
	// @Override
	// public boolean isAbgeschlossen() {
	// return abgeschlossen;
	// }
	//
	// @Override
	// public Date getBeauftragtAm() {
	// return new Date();
	// }
	//
	// @Override
	// public IAngebot getAngebot() {
	// return angebot;
	// }
	//
	// @Override
	// public ILieferung getLieferung() {
	// return null;
	// }
	//
	// @Override
	// public IRechnung getRechnung() {
	// return rechnung;
	// }
	//
	// }
	//
	// private class MyAngebotMockUp implements IAngebot {
	//
	// protected MyAngebotMockUp(int preis) {
	// this.preis = preis;
	// }
	//
	// int preis;
	//
	// @Override
	// public List<IProduktMenge> getProdukte() {
	// return null;
	// }
	//
	// @Override
	// public IKunde getKunde() {
	// return null;
	// }
	//
	// @Override
	// public Date getGueltigBis() {
	// return null;
	// }
	//
	// @Override
	// public Date getGueltigAb() {
	// return null;
	// }
	//
	// @Override
	// public int getGesamtpreis() {
	// return preis;
	// }
	//
	// @Override
	// public IAuftrag getAuftrag() {
	// return null;
	// }
	//
	// @Override
	// public int getAngebotsNr() {
	// return 0;
	// }
	// };
}
