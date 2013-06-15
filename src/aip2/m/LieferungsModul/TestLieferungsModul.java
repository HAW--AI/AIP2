package aip2.m.LieferungsModul;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import aip2.m.PersistenzModul.IPersistenzSessionIntern;
//import aip2.m.PersistenzModul.Persistenz;
import aip2.m.TransaktionModul.ITransaktionIntern;
//import aip2.m.TransaktionModul.Transaktion;

public class TestLieferungsModul {

	@SuppressWarnings("unused")
	private static LieferungModulFassade lieferungModulFassade;
//	private static LieferungModulLogik lieferungModulLogik;
//	private static LieferungVerwalter lieferungVerwalter;
//	private static TransportauftragVerwalter transportauftragVerwalter;
//	private static IPersistenzSessionIntern persistenzSession;
	private static ITransaktionIntern transaktion;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

//		persistenzSession = Persistenz.getPersistenzSessionIntern();
//		transaktion = Transaktion.getTransaktion(persistenzSession);
//		transportauftragVerwalter = new TransportauftragVerwalter(
//				persistenzSession);
//		lieferungModulLogik = new LieferungModulLogik(lieferungVerwalter,
//				transportauftragVerwalter);
//		lieferungModulFassade = new LieferungModulFassade(lieferungModulLogik,
//				lieferungVerwalter, transportauftragVerwalter, transaktion);
	}

	@Before
	public void beforeEach() {
		transaktion.startTransaction();
	}

	@After
	public void afterEach() {
		transaktion.rollbackTransaction();
	}

	@Test
	public void test() {
		// lieferungModulFassade.erzeugeLieferung(null);
		assert (true);
	}

}
