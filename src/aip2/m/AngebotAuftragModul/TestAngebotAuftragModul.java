package aip2.m.AngebotAuftragModul;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aip2.m.KundenModul.IKundeIntern;
import aip2.m.KundenModul.KundenModul;
import aip2.m.LieferungsModul.ILieferungModulIntern;
import aip2.m.PersistenzModul.IPersistenzSessionIntern;
import aip2.m.PersistenzModul.Persistenz;
import aip2.m.ProduktModul.IProduktIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;
import aip2.m.TransaktionModul.Transaktion;

public class TestAngebotAuftragModul {

	private static IPersistenzSessionIntern persistenzSession;
	private static ITransaktionIntern transaktion;

	private static AngebotAuftragModulLogik angebotAuftragModulLogik;
	private static AngebotVerwalter angebotVerwalter;
	private static AuftragVerwalter auftragVerwalter;

	@SuppressWarnings("unused")
	private static AngebotAuftragModulFassade angebotAuftragModulFassade;

	private static IProduktIntern iProduktIntern;
	@SuppressWarnings("unused")
	private static ILieferungModulIntern iLieferungModulIntern;
	private static IKundeIntern iKundeIntern;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		persistenzSession = Persistenz.getPersistenzSessionIntern();
		transaktion = Transaktion.getTransaktion(persistenzSession);
		angebotVerwalter = new AngebotVerwalter(persistenzSession);
		auftragVerwalter = new AuftragVerwalter(persistenzSession);
		angebotAuftragModulLogik = new AngebotAuftragModulLogik(
				angebotVerwalter, auftragVerwalter);
		
		iKundeIntern = KundenModul.getIKundeIntern(persistenzSession, transaktion);
		
		angebotAuftragModulFassade = new AngebotAuftragModulFassade(
				transaktion, angebotAuftragModulLogik, angebotVerwalter,
				auftragVerwalter, iProduktIntern, null, iKundeIntern);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assert(true);
	}

}
