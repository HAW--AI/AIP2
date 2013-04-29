package aip2.m;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public interface IAngebot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "angebot_nr")
	public abstract int getNr();

	public abstract long getGueltigAb();

	public abstract long getGueltigBis();

	public abstract int getGesamtpreis();

	@OneToOne(mappedBy = "angebot")
	public abstract IAuftrag getAuftrag();

	@ManyToOne(/*mappedBy = "angebote"*/)
	public abstract IKunde getKunde();

	@ManyToMany(mappedBy = "angebot")
	public abstract HashSet<Produkt> getProdukte();

}