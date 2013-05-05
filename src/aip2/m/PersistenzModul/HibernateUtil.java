package aip2.m.PersistenzModul;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hilfsklasse um Hibernate zu konfigurieren und eine initiale Verbindung
 * aufzubauen
 * 
 */
final class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		File configFile = new File(
				"src/aip2/m/PersistenzModul/hibernate.cfg.xml");
		Configuration conf = new Configuration().configure(configFile);
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				conf.getProperties()).buildServiceRegistry();
		try {
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}