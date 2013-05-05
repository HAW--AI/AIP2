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
class KundenModulFassade implements IKundenModulExtern {

	private static KundenModulFassade kundenFassade;

	private final KundenModulLogik kundenLogik;
	private final KundenVerwalter kundenVerwalter;
	private final ITransaktionIntern transaktion;

	private KundenModulFassade(IPersistenzIntern persistenz,
			ITransaktionIntern transaktion) {
		this.transaktion = transaktion;
		this.kundenVerwalter = new KundenVerwalter(persistenz);
		this.kundenLogik = new KundenModulLogik(kundenVerwalter);
	}

	public static KundenModulFassade getKundenFassade(
			IPersistenzIntern persistenz, ITransaktionIntern transaktion) {
		if (kundenFassade == null)
			kundenFassade = new KundenModulFassade(persistenz, transaktion);
		return kundenFassade;
	}

	/**
	 * Für JunitTest ONLY !!!
	 */
	KundenModulFassade(KundenModulLogik kundenLogik,
			KundenVerwalter kundenVerwalter, ITransaktionIntern transaktion) {
		this.kundenLogik = kundenLogik;
		this.kundenVerwalter = kundenVerwalter;
		this.transaktion = transaktion;
	}

	@Override
	public List<KundenTyp> sucheKunden(String name) {
		return kundenLogik.sucheKunden(name);
	}

	@Override
	public KundenTyp sucheKunden(int kundenId) {
		return kundenLogik.sucheKunden(kundenId);
	}

	@Override
	public KundenTyp erstelleKunde(String name, String adresse) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			KundenTyp kunde = kundenLogik.erstelleKunde(name, adresse);

			if (myTransaction)
				transaktion.commitTransaction();

			return kunde;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return null;
		}
	}

}
