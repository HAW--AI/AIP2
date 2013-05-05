package aip2.m.KundenModul;

import java.util.List;

import aip2.m.InterfacesExtern.IKundenModulExtern;
import aip2.m.PersistenzModul.IPersistenzIntern;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Stellt die Schnittstelle für externe Operationen und startet die
 * Kundenkomponente
 * 
 */
class KundenFassade implements IKundenModulExtern {

	private static KundenFassade kundenFassade;

	private final KundenLogik kundenLogik;
	private final KundenVerwalter kundenVerwalter;
	private final ITransaktionIntern transaktion;

	private KundenFassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		this.transaktion = transaktion;
		this.kundenVerwalter = new KundenVerwalter(persistenz);
		this.kundenLogik = new KundenLogik(kundenVerwalter);
	}

	public static KundenFassade startKundenFassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		if (kundenFassade == null)
			kundenFassade = new KundenFassade(persistenz, transaktion);
		return kundenFassade;
	}

	/**
	 * Für JunitTest ONLY !!!
	 */
	KundenFassade(KundenLogik kundenLogik, KundenVerwalter kundenVerwalter,
			ITransaktionIntern transaktion) {
		this.kundenLogik = kundenLogik;
		this.kundenVerwalter = kundenVerwalter;
		this.transaktion = transaktion;
	}

	@Override
	public List<KundenTyp> sucheKunden(String name) {
		return kundenLogik.sucheKunden(name);
	}

	@Override
	public IKunde erstelleKunde(String name, String adresse) {
		boolean myTransaction;
		myTransaction = false;
		if (!transaktion.isRunningTransaction()) {
			transaktion.startTransaction();
			myTransaction = true;
		}
		IKunde kunde = kundenVerwalter.erstelleKunde(name, adresse);

		if (myTransaction)
			transaktion.commitTransaction();

		return kunde;
	}

	@Override
	public KundenTyp sucheKunden(int kundenId) {
		return kundenLogik.sucheKunden(kundenId);
	}

}
