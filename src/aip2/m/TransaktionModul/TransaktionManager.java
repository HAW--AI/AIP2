package aip2.m.TransaktionModul;

import org.hibernate.Session;
import org.hibernate.Transaction;

import aip2.m.PersistenzModul.IPersistenzSessionIntern;

/**
 * Verwaltet Transaktionen
 * 
 */
final class TransaktionManager implements ITransaktionIntern {

	private boolean runningTransaction;
	private IPersistenzSessionIntern persistenz;
	private Transaction transaktion;

	TransaktionManager(IPersistenzSessionIntern persistenz) {
		this.persistenz = persistenz;
	}

	@Override
	public boolean isRunningTransaction() {
		return runningTransaction;
	}

	@Override
	public boolean startTransaction() /* throws TransactionNotClosed */{
		Session session = getCurrentSession();
		if (session == null)
			return false;
		transaktion = session.beginTransaction();
		runningTransaction = true;
		return true;
	}

	@Override
	public boolean checkStartMyTransaction() {
		if (!isRunningTransaction()) {
			Session session = getCurrentSession();
			if (session == null)
				persistenz.openNewSession();
			transaktion = session.beginTransaction();
			runningTransaction = true;
			return true;
		} else
			return false;
	}

	@Override
	public boolean commitTransaction() {
		Session session = getCurrentSession();
		if (session == null)
			return false;
//		session.getTransaction().commit();
		transaktion.commit();
		runningTransaction = false;
		return true;
	}

	@Override
	public boolean rollbackTransaction() {
		Session session = getCurrentSession();
		if (session == null)
			return false;
//		session.getTransaction().rollback();
		transaktion.rollback();
		runningTransaction = false;
		return true;
	}

	private Session getCurrentSession() {
		if (persistenz.isSessionOpen())
			return persistenz.getSession();
		return null;
	}
}
