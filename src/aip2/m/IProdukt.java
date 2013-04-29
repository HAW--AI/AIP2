package aip2.m;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public interface IProdukt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produkt_nr")
	public abstract int getNr();

	public abstract String getName();

	public abstract int getLagerbestand();

	@ManyToMany(mappedBy = "produkte")
	public abstract HashSet<Angebot> getAngebote();

	@OneToMany(mappedBy = "produkt")
	public abstract HashSet<Warenausgangsmeldung> getWarenausgangsmeldungen();

	@OneToMany(mappedBy = "produkt")
	public abstract HashSet<Bestellung> getBestellungen();

	@OneToOne(mappedBy = "produkt")
	public abstract IOrderbuch getOrderbuch();

	@OneToMany(mappedBy = "produkt")
	public abstract HashSet<Einkaufsinfosatz> getEinkaufsinfosaetze();

}