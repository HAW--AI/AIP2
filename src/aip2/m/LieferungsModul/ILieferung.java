package aip2.m.LieferungsModul;

import aip2.m.AngebotAuftragModul.IAuftrag;

public interface ILieferung {

	int getLieferungsNr();

	IAuftrag getAuftrag();

	ITransportauftrag getTransportauftrag();

}