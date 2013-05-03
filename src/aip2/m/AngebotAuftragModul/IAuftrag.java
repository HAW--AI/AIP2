package aip2.m.AngebotAuftragModul;

import java.util.Date;

import aip2.m.LieferungsModul.ILieferung;
import aip2.m.RechnungsModul.IRechnung;

public interface IAuftrag {

	int getAuftragsNr();

	boolean isAbgeschlossen();

	Date getBeauftragtAm();

	IAngebot getAngebot();

	ILieferung getLieferung();

	IRechnung getRechnung();

}