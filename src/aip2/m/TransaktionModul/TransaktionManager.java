package aip2.m.TransaktionModul;

import org.hibernate.Session;

import aip2.m.PersistenzModul.IPersistenzSessionIntern;

/**
 * Verwaltet Transaktionen
 *
 */
final class TransaktionManager implements ITransaktionIntern {

	private boolean runningTransaction;
	private IPersistenzSessionIntern persistenz;

	TransaktionManager(IPersistenzSessionIntern persistenz) {
		this.persistenz = persistenz;
	}

	public boolean isRunningTransaction() {
		return runningTransaction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aip2.m.TransaktionsModul.ITransaktionIntern#startTransaction()
	 */
	@Override
	public boolean startTransaction() /*throws TransactionNotClosed*/ {
		Session session = getCurrentSession();
		if (session == null)
			return false;
		session.beginTransaction();
		runningTransaction = true;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aip2.m.TransaktionsModul.ITransaktionIntern#commitTransaction()
	 */
	@Override
	public boolean commitTransaction() {
		Session session = getCurrentSession();
		if (session == null)
			return false;
		session.getTransaction().commit();
		runningTransaction = false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aip2.m.TransaktionsModul.ITransaktionIntern#rollbackTransaction()
	 */
	@Override
	public boolean rollbackTransaction() {
		Session session = getCurrentSession();
		if (session == null)
			return false;
		session.getTransaction().rollback();
		runningTransaction = false;
		return true;
	}

	private Session getCurrentSession() {
		if (persistenz.isSessionOpen())
			return persistenz.getSession();
		return null;
	}

}
