package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.Map;

import aip2.m.KundenModul.IKunde;
import aip2.m.ProduktModul.IProdukt;

public interface IAngebot {

	int getAngebotsNr();

	Date getGueltigAb();

	Date getGueltigBis();

	int getGesamtpreis();

	IAuftrag getAuftrag();

	IKunde getKunde();

	Map<IProdukt, Integer>/* List<IProduktMenge> */getProdukte();

}