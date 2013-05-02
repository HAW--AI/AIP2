package aip2.m.PersistenzModul;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration conf = new Configuration();
		conf.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				conf.getProperties()).buildServiceRegistry();
		try {
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static <T> Serializable add(T thing) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			Serializable ret = session.save(thing);

			session.getTransaction().commit();

			return ret;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	public static <T> List<T> getAll(T type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria = session.createCriteria(type.getClass());

			@SuppressWarnings("unchecked")
			List<T> all = criteria.list();

			return all;

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	public static <T> void update(T thing) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			session.update(thing);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public static <T> void delete(T thing) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();

			session.delete(thing);

			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	// private static final SessionFactory sessionFactory =
	// buildSessionFactory();
	//
	// @SuppressWarnings("deprecation")
	// private static SessionFactory buildSessionFactory() {
	// try {
	// // Create the SessionFactory from hibernate.cfg.xml
	// return new Configuration().configure().buildSessionFactory();
	// } catch (Throwable ex) {
	// // Make sure you log the exception, as it might be swallowed
	// System.err.println("Initial SessionFactory creation failed." + ex);
	// throw new ExceptionInInitializerError(ex);
	// }
	// }
	//
	// public static SessionFactory getSessionFactory() {
	// return sessionFactory;
	// }

}