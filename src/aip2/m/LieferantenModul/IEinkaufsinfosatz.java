package aip2.m.LieferantenModul;

import java.util.Date;

import aip2.m.ProduktModul.IProdukt;

public interface IEinkaufsinfosatz {

	int getEinkaufsinfosatzNr();

	Date getGueltigAb();

	Date getGueltigBis();

	int getPlanlieferzeit();

	int getNormalmenge();

	int getPreis();

	IProdukt getProdukt();

	ILieferant getLieferant();

}