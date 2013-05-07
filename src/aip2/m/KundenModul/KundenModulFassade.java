package aip2.m.KundenModul;

import java.util.List;

import aip2.m.InterfacesExtern.IKundenModulExtern;
import aip2.m.TransaktionModul.ITransaktionIntern;

/**
 * Stellt die Schnittstelle für externe Operationen und startet die
 * Kundenkomponente
 * 
 */
class KundenModulFassade implements IKundenModulExtern, IKundeIntern {

	private final KundenModulLogik kundenLogik;
	private final KundenVerwalter kundenVerwalter;
	private final ITransaktionIntern transaktion;

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

	@Override
	public IKunde getKunde(int nr) {
		return kundenVerwalter.getKundeById(nr);
	}

}
