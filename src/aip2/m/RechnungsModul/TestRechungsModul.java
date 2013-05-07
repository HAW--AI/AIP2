package aip2.m.RechnungsModul;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
	public void testIRechnungsModul() {
		rechnungModulFassade.erzeugeZahlungsEingang(new Date(), 100);

		// IZahlungseingang zahlung = rechnungModulFassade
		// .erzeugeZahlungsEingangReturn(new Date(), 100);

		List<Zahlungseingang> list = persistenzSession
				.getAll(Zahlungseingang.class);
		assertTrue(list.size() > 0);

//		IRechnung rechnung = rechnungModulFassade.erzeugeRechnung(null);

		// rechnungModulFassade.verbucheTeilZahlungseingang(rechnung.getRechnungsNr(),
		// zahlung);
	}

}
