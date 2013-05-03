package aip2.m.LieferungsModul;

import java.util.Date;

public interface ITransportauftrag {

	int getTransportAuftragNr();

	ILieferung getLieferung();

	Date getAusgangsDatum();

	boolean isLieferungErfolgt();

	Date getLieferDatum();

	String getTransportDienstleister();
}