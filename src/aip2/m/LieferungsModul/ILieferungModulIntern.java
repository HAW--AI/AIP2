package aip2.m.LieferungsModul;

import aip2.m.AngebotAuftragModul.IAuftrag;

public interface ILieferungModulIntern {
	
	ILieferung erzeugeLieferung(IAuftrag auftrag);
}
