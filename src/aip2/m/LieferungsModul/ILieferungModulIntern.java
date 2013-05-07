package aip2.m.LieferungsModul;

import aip2.m.AngebotAuftragModul.IAuftrag;

/**
 * Operationen des LieferungsModul für die HES interne Nutzung
 * 
 */
public interface ILieferungModulIntern {

	/**
	 * Erzeugt eine komplett Lieferung für den Auftrag
	 * 
	 * @param auftrag
	 * @return die erstellte Lieferung oder null bei Misserfolg
	 */
	ILieferung erzeugeLieferung(IAuftrag auftrag);
}
