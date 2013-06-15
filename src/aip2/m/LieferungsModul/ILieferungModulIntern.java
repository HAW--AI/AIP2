package aip2.m.LieferungsModul;


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
	ILieferung erzeugeLieferung(String adresse/*IAuftrag auftrag*/);
}
