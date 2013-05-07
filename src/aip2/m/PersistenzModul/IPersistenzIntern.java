package aip2.m.PersistenzModul;

import java.util.List;

/**
 * Adapter der Entitäten mit Hibernate in einer DB speichert und die EINE offene
 * Session zur DB verwaltet. NICHT Threadsafe, da es nur jeweils eine Session
 * gibt! 
 * 
 * TODO Verursacht HibernateExceptions, da können wir aber eh wenig tun
 * 
 */
public interface IPersistenzIntern {
	/**
	 * Speichert eine Entität in der DB
	 * 
	 * @param thing
	 *            Das zu speichernde etwas
	 */
	<T> void add(T thing);

	/**
	 * Sucht ein Objekt in der DB anhand seiner Eindeutigen ID
	 * 
	 * @param type
	 *            die Klasse des gesuchten Objektes
	 * @param id
	 *            die Id des Objektes
	 * @return das gesuchte Objekt oder null, falls kein Objekt mit dieser Id
	 *         existiert
	 */
	<T> T getById(Class<T> type, int id);

	/**
	 * Sucht alle gespeicherten Objekte einer Klasse
	 * 
	 * @param type
	 *            die Klasse des gesuchten Objekte
	 * @return eine Liste aller in der DB gespeicherten Objekte
	 */
	<T> List<T> getAll(Class<T> type);

	/**
	 * Sucht in der Tabelle des Types nach Objekten deren Wert in der Spalte
	 * columnName value ist
	 * 
	 * @param type
	 *            der gesuchte Typ(der KlassenName wird als Tabelle angenommen)
	 * @param columnName
	 * @param value
	 * @return Eine leere Liste falls keine Einträge gefunden wurden, sonst eine
	 *         volle Liste
	 */
	<T> List<T> getFromWhere(Class<T> type, String columnName, Object value);

	/**
	 * Aktualisiert eine Entität in der DB
	 * 
	 * @param thing
	 *            Das zu aktualisierende etwas
	 */
	<T> void update(T thing);

	/**
	 * Löscht eine Entität in der DB
	 * 
	 * @param thing
	 *            Das zu löschende etwas
	 */
	<T> void delete(T thing);

	/**
	 * Prüft ob eine Verbindung zu Datenbank offen ist
	 * 
	 * @return verbindungsstatus
	 */
	boolean isSessionOpen();

	/**
	 * Schließt die alte Verbindung und baut eine neue auf
	 * 
	 * @return erfolgsWert
	 */
	boolean openNewSession();

	/**
	 * Schließt die bestehende Verbindung zu DB
	 * 
	 * @return erfolgsWert
	 */
	boolean closeSession();

}