package aip2.m.LieferantenModul;

import java.util.Set;

import aip2.m.ProduktModul.IProdukt;

public interface IOrderbuch {

	int getOrderBuchNr();

	IProdukt getProdukt();

	Set<IOrderbuchsatz> getOrderbuchsaetze();

}