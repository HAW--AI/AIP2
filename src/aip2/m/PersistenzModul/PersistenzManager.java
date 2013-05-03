package aip2.m.PersistenzModul;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import aip2.m.TransaktionsModul.TransaktionManager;

public class PersistenzManager implements IPersistenzIntern {

	private TransaktionManager transaktionsManager;

	public PersistenzManager(TransaktionManager transaktionsManager) {
		this.transaktionsManager = transaktionsManager;
		transaktionsManager.setSessionFactory(getSessionFactory());
	}

	public <T> Serializable add(T thing) {
		Serializable ret = getSession().save(thing);
		return ret;
	}

	public <T> T getById(Class<T> idClass, int id) {
		return idClass.cast(getSession().get(idClass, id));
	}

	public <T> List<T> getAll(Class<T> type) {
		Criteria criteria = getSession().createCriteria(type);
		@SuppressWarnings("rawtypes")
		List critList = criteria.list();
		List<T> resultList = new ArrayList<T>();

		for (@SuppressWarnings("rawtypes")
		Iterator iterator = critList.iterator(); iterator.hasNext();) {
			T typeThingX = type.cast(iterator.next());
			resultList.add(typeThingX);
		}
		return resultList;
	}

	public <T> void update(T thing) {
		getSession().update(thing);
	}

	public <T> void delete(T thing) {
		getSession().delete(thing);
	}

	private Session getSession() {
		return transaktionsManager.getSession();
	}

	public SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

}
