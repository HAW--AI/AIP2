package aip2.m.ProduktModul;

import java.util.List;

import aip2.m.PersistenzModul.IPersistenzIntern;

final class ProduktVerwalter {
	private final IPersistenzIntern persistenz;

	ProduktVerwalter(IPersistenzIntern persistenz) {
		this.persistenz = persistenz;
	}

	IProdukt erstelleProdukt(String name, int lagerbestand) {
		IProdukt produkt = new Produkt(name, lagerbestand);

		persistenz.add(produkt);
		return produkt;
	}

	Produkt getProduktById(int nr) {
		return persistenz.getById(Produkt.class, nr);
	}
	
	List<Produkt> getProduktByName(String name) {
		return persistenz.getFromWhere(Produkt.class, "name", name);
	}

	ProduktTyp getProduktTyp(IProdukt produkt) {
		ProduktTyp produktTyp = new ProduktTyp(produkt.getProduktNr(), produkt.getName());
		return produktTyp;
	}
	
	void updateProdukt(IProdukt produkt) {
		persistenz.update(produkt);
	}

}
