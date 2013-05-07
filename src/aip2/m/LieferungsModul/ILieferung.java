package aip2.m.LieferungsModul;

/**
 * Read only Sicht auf eineLieferung
 * 
 */
public interface ILieferung {

	/**
	 * Gibt die LieferungNr
	 * 
	 * @return LieferungNr
	 */
	int getLieferungsNr();

	/**
	 * Gibt den zugehörigen Transportauftrag
	 * 
	 * @return Transportauftrag
	 */
	ITransportauftrag getTransportauftrag();

}