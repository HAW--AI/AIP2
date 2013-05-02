package aip2.m.Interfaces;

import java.util.HashSet;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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