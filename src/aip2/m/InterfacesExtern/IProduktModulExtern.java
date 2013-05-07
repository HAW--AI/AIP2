package aip2.m.InterfacesExtern;

import java.util.List;

import aip2.m.ProduktModul.ProduktTyp;

public interface IProduktModulExtern {

	List<ProduktTyp> sucheProdukt(String name);
	
	ProduktTyp sucheProdukt(int id);
	
	ProduktTyp erstelleProdukt(String name, int mengeImLager);
}
