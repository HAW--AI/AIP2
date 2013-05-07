package aip2.m.KundenModul;

/**
 * Operationen des KundenModul für die HES interne Nutzung
 * 
 */
public interface IKundenModulIntern {
	/**
	 * Liefert ein Kunden Objekt mit der gewünschten Id
	 * 
	 * @param nr
	 * @return Der Kunde
	 */
	IKunde getKunde(int nr);

}
