package aip2.m.PersistenzModul;

import org.hibernate.Session;

/**
 * Technische Schnittstelle, die die aktuelle HibernateSession zur verfügung stellt
 *
 */
public interface IPersistenzSessionIntern extends IPersistenzIntern{

	/**
	 * Liefert das aktuelle Session Objekt
	 * @return die aktuelle Session
	 */
	Session getSession();
	
}
