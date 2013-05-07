package aip2.m.tests;

import org.junit.runner.*;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import aip2.m.AngebotAuftragModul.TestAngebotAuftragModul;
import aip2.m.KundenModul.TestKundenModul;

import aip2.m.RechnungsModul.TestRechungsModul;

@RunWith(Suite.class)
@SuiteClasses({ TestKundenModul.class, TestRechungsModul.class,
		TestAngebotAuftragModul.class })
public class KomponentenTestSuite {

	// public static void main(String[] args) {
	// // IPersistenzSessionIntern persistenz =
	// // Persistenz.getPersistenzSessionIntern();
	// // ITransaktionIntern transaktion =
	// // Transaktion.getTransaktion(persistenz);
	//
	// // boolean test = transaktion.checkStartMyTransaction();
	//
	// // System.out.println(test);
	//
	// // Produkt p = new Produkt("test1", 100);
	// // persistenz.add(p);
	//
	// // Kunde k = new Kunde("na", "hier");
	// // persistenz.add(k);
	//
	// System.out.println("Start");
	// // Result result = JUnitCore.runClasses(KomponentenTestSuite.class);
	// // for (Failure failure : result.getFailures()) {
	// // System.out.println(failure.toString());
	// // }
	// // System.out.println(result.wasSuccessful());
	//
	// // transaktion.commitTransaction();
	//
	// System.out.println("Stop");
	// }
}
