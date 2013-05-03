package aip2.m;

import java.util.Iterator;
import java.util.List;
import aip2.m.KundenModul.Kunde;
import aip2.m.PersistenzModul.PersistenzManager;
import aip2.m.TransaktionsModul.SessionNotClosed;
import aip2.m.TransaktionsModul.TransactionNotClosed;
import aip2.m.TransaktionsModul.TransaktionManager;

public class TestHB {

	public static void main(String[] args) {
		TransaktionManager transManager = new TransaktionManager();
		PersistenzManager persistenz = new PersistenzManager(transManager);

		int id = 0;
		try {
			transManager.getNewSession();

			try {
				transManager.startTransaction();

				Kunde k = new Kunde("Hans", "home");
				persistenz.add(k);
				id = k.getNr();
				transManager.commitTransaction();
			} catch (TransactionNotClosed e) {
				e.printStackTrace();
			}catch (Exception e){
				transManager.rollbackTransaction();
				e.printStackTrace();
			}

			Kunde kuno = persistenz.getById(Kunde.class, id);
			System.out.println(kuno);

			List<Kunde> oL = persistenz.getAll(Kunde.class);
			try {
				transManager.startTransaction();
				for (Iterator<Kunde> iterator = oL.iterator(); iterator
						.hasNext();) {
					Kunde k1 = iterator.next();
					System.out.println(k1);

					persistenz.delete(k1);
				}
				transManager.commitTransaction();
			} catch (TransactionNotClosed et) {
				et.printStackTrace();
			}catch (Exception e){
				transManager.rollbackTransaction();
				e.printStackTrace();
			}
			
			transManager.closeSession();

		} catch (SessionNotClosed es) {
			es.printStackTrace();
		}

	}
}
