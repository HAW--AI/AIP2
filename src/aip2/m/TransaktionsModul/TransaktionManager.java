package aip2.m.TransaktionsModul;

import org.hibernate.SessionFactory;
import org.hibernate.Session;


public class TransaktionManager implements ITransaktionIntern {
	private SessionFactory sessionFactory;
	private Session session = null;

	public TransaktionManager() {
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}
	
	public Session getSession() {
		return session;
	}

	public boolean startTransaction() throws TransactionNotClosed {
		if (session == null)
			return false;
		session.beginTransaction();
		return true;
	}

	public boolean commitTransaction() {
		if (session == null)
			return false;
		session.getTransaction().commit();
		return true;
	}

	public boolean rollbackTransaction() {
		if (session == null)
			return false;
		session.getTransaction().rollback();
		return true;
	}

	public boolean getNewSession() throws SessionNotClosed {
		if (!(session == null) && session.isConnected())
			throw new SessionNotClosed();
		else {
			this.session = sessionFactory.openSession();
		}
		return true;
	}

	public boolean closeSession() {
		if (session == null)
			return true;
		else {
			session.close();
			return true;
		}
	}
}
