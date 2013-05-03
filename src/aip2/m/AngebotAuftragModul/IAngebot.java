package aip2.m.AngebotAuftragModul;

import java.util.Map;

import aip2.m.Interfaces.IAuftrag;
import aip2.m.KundenModul.IKunde;
import aip2.m.ProduktModul.Produkt;

public interface IAngebot {

	public abstract int getNr();

	public abstract long getGueltigAb();

	public abstract long getGueltigBis();

	public abstract int getGesamtpreis();

	public abstract IAuftrag getAuftrag();

	public abstract IKunde getKunde();

	public abstract Map<Produkt, Integer> getProdukte();

}