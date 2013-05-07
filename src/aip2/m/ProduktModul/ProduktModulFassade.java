package aip2.m.ProduktModul;

import java.util.List;

import aip2.m.InterfacesExtern.IProduktModulExtern;
import aip2.m.TransaktionModul.ITransaktionIntern;

public class ProduktModulFassade implements IProduktModulIntern, IProduktModulExtern {

	private final ProduktModulLogik produktLogik;
	@SuppressWarnings("unused")
	private final ProduktVerwalter produktVerwalter;
	private final ITransaktionIntern transaktion;

	ProduktModulFassade(ProduktModulLogik produktLogik,
			ProduktVerwalter produktVerwalter, ITransaktionIntern transaktion) {
		this.produktLogik = produktLogik;
		this.produktVerwalter = produktVerwalter;
		this.transaktion = transaktion;
	}

	@Override
	public List<ProduktTyp> sucheProdukt(String name) {
		return produktLogik.sucheProdukt(name);
	}

	@Override
	public ProduktTyp sucheProdukt(int id) {
		return produktLogik.sucheProdukt(id);
	}
	
	@Override
	public IProdukt getProdukt(int id) {
		return produktLogik.getProdukt(id);
	}
	
	@Override
	public boolean lagereAusProdukt(IProdukt produkt, int menge) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();
			boolean b = produktLogik.lagereAusProdukt(produkt, menge);
			if (myTransaction) transaktion.commitTransaction();
			return b;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return false;
		}
	}
}
