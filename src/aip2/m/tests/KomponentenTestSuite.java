package aip2.m.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import aip2.m.KundenModul.TestKundenModul;
import aip2.m.RechnungsModul.TestRechungsModul;

@RunWith(Suite.class)
@SuiteClasses({ TestKundenModul.class , TestRechungsModul.class})
public class KomponentenTestSuite {

}
