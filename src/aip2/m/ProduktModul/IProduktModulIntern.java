package aip2.m.ProduktModul;


public interface IProduktModulIntern {
	
	boolean lagereAusProdukt(IProdukt produkt, int menge);

	IProdukt getProdukt(int id);
}
