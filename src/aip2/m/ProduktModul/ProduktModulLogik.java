package aip2.m.ProduktModul;

import java.util.ArrayList;
import java.util.List;

public class ProduktModulLogik {
	private final ProduktVerwalter produktVerwalter;

	ProduktModulLogik(ProduktVerwalter pv) {
		this.produktVerwalter = pv;
	}
	
	public List<ProduktTyp> sucheProdukt(String name) {
		List<Produkt> list = produktVerwalter.getProduktByName(name);
		
		List<ProduktTyp> produktTypListe = new ArrayList<ProduktTyp>();
		for (Produkt produkt : list) {
			ProduktTyp p = produktVerwalter.getProduktTyp(produkt);
			produktTypListe.add(p);
		}

		return produktTypListe;
	}

	public ProduktTyp sucheProdukt(int id) {
		Produkt k = produktVerwalter.getProduktById(id);
		return produktVerwalter.getProduktTyp(k);
	}
	
	public IProdukt getProdukt(int id) {
		return produktVerwalter.getProduktById(id);
	}
	
	public boolean lagereAusProdukt(IProdukt produkt, int menge) {
		// Immer genug vorhanden!
		// TODO: Warenausgangsmeldung
		
		Produkt p = produktVerwalter.getProduktById(produkt.getProduktNr());
		p.setLagerbestand(p.getLagerbestand() - menge);
		produktVerwalter.updateProdukt(p);
		return true;
	}


}
