package aip2.m.LieferantenModul;

import java.util.Date;

public interface IOrderbuchsatz {

	int getOrderbuchsatzNr();

	Date getGueltigAb();

	Date getGueltigBis();

	IOrderbuch getOrderbuch();

	ILieferant getLieferant();

}