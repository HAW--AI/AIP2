package aip2.m.PersistenzModul;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Implementiert die Persistenz Schnittstelle IPersitenzIntern
 * 
 * @see http 
 *      ://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.
 *      html
 * @see http
 *      ://www.galileocomputing.de/artikel/gp/artikelID-328?GalileoSession=52213403
 *      A6AyfB.WMUE#abschnitt0
 * 
 */
final class PersistenzManager implements IPersistenzIntern,
		IPersistenzSessionIntern {

	private SessionFactory sessionFactory;
	private Session session;

	PersistenzManager() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
		this.session = sessionFactory.openSession();
	}

	@Override
	public <T> void add(T thing) {
		if (!isSessionOpen()) {
			openNewSession();
		}
		getSession().save(thing);
	}

	@Override
	public <T> T getById(Class<T> idClass, int id) {
		if (!isSessionOpen()) {
			openNewSession();
		}
		return idClass.cast(getSession().get(idClass, id));
	}

	@Override
	public <T> List<T> getAll(Class<T> type) {
		if (!isSessionOpen()) {
			openNewSession();
		}

		Criteria criteria = getSession().createCriteria(type);

		return reCastListTo(type, criteria.list());
	}

	@Override
	public <T> List<T> getFromWhere(Class<T> type, String columnName,
			Object value) {

		if (!isSessionOpen()) {
			openNewSession();
		}
		Query query = session.createQuery("from " + type.getSimpleName()
				+ " where " + columnName + " = :value");
		query.setParameter("value", value);

		return reCastListTo(type, query.list());

	}

	@SuppressWarnings("rawtypes")
	private <T> List<T> reCastListTo(Class<T> type, List list) {
		List<T> resultList = new ArrayList<T>();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			T typeThingX = type.cast(iterator.next());
			resultList.add(typeThingX);
		}

		return resultList;
	}

	@Override
	public <T> void update(T thing) {
		if (!isSessionOpen()) {
			openNewSession();
		}
		getSession().update(thing);
	}

	@Override
	public <T> void delete(T thing) {
		if (!isSessionOpen()) {
			openNewSession();
		}
		getSession().delete(thing);
	}

	@Override
	public boolean isSessionOpen() {
		return session != null && session.isConnected();
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public boolean openNewSession() {
		if (isSessionOpen())
			closeSession();
		else {
			this.session = sessionFactory.openSession();
		}
		return true;
	}

	@Override
	public boolean closeSession() {
		if (session == null)
			return true;
		else {
			session.close();
			return true;
		}
	}

}
