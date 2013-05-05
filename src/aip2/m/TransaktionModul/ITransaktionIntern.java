package aip2.m.TransaktionModul;

/**
 * Verwaltet Transaktionen es ist nur eine Transaktion gleichzeitig möglich, es
 * gibt keine geschachtelten Transaktionen.
 * 
 * Vor jeder Transaktion sollte geprüft werden ob bereits eine Transaktion
 * läuft.
 * TODO mehere Transaktion gleichzeitig -> Peristenz mehr als eine Session
 * 
 */
public interface ITransaktionIntern {

	/**
	 * Prüft, ob bereits eine Transaktion läuft
	 * 
	 * @return laufendeTransaktion?
	 */
	boolean isRunningTransaction();

	/**
	 * startet eine neue Transaktion
	 * 
	 * @pre erst prüfen mit isRunningTransaction(), ob schon eine Transaktion
	 *      läuft
	 * @return false wenn keine Transaktion gestartet werden könnte, sonst true.
	 *         //*@throws TransactionNotClosed //* um zu verhinden, dass
	 *         Transaktionen nicht commitet werden
	 */
	boolean startTransaction();

	/**
	 * Prüft bevor eine neue Transaktion aufgebaut wird, falls keine vorhanden
	 * ist wird eine neue eröffnet und MyTransaction wird true
	 * 
	 * @return Habe ich die Transaktion gestartet? aka true gibt an Transaktion
	 *         wurde gerade gestartet, bei false lief bereits eine Transaktion
	 */
	boolean checkStartMyTransaction();

	/**
	 * Commitet eine Transaktion
	 * 
	 * @return false wenn keine Verbindung zur DB besteht, sonst true.
	 */
	boolean commitTransaction();

	/**
	 * Vergisst eine Transaktion
	 * 
	 * @return false wenn keine Verbindung zur DB besteht, sonst true.
	 */
	boolean rollbackTransaction();

}