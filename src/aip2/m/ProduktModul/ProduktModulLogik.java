package aip2.m.ProduktModul;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aip2.m.WarenmeldungsModul.IWarenmeldungsModulIntern;

public class ProduktModulLogik {
	private final ProduktVerwalter produktVerwalter;
	private final IWarenmeldungsModulIntern warenmeldungsModulIntern;
	
	ProduktModulLogik(ProduktVerwalter produktVerwalter, IWarenmeldungsModulIntern warenmeldungsModulIntern) {
		this.produktVerwalter = produktVerwalter;
		this.warenmeldungsModulIntern = warenmeldungsModulIntern;
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
		
		Produkt p = produktVerwalter.getProduktById(produkt.getProduktNr());
		p.setLagerbestand(p.getLagerbestand() - menge);
		produktVerwalter.updateProdukt(p);
		
		warenmeldungsModulIntern.erstelleWarenausgangsmeldung(new Date(), menge, produkt);		
		return true;
	}

	public ProduktTyp erstelleProdukt(String name, int mengeImLager) {
		IProdukt p = produktVerwalter.erstelleProdukt(name, mengeImLager);
		return produktVerwalter.getProduktTyp(p);
	}


}
