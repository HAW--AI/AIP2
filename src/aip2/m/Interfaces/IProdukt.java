package aip2.m.Interfaces;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import aip2.m.AngebotAuftragModul.Angebot;
import aip2.m.BestellungsModul.Bestellung;
import aip2.m.LieferantenModul.Einkaufsinfosatz;
import aip2.m.WarenmeldungsModul.Warenausgangsmeldung;

public interface IProdukt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produkt_nr")
	public abstract int getNr();

	public abstract String getName();

	public abstract int getLagerbestand();

	@ManyToMany(mappedBy = "produkte")
	public abstract Set<Angebot> getAngebote();

	@OneToMany(mappedBy = "produkt")
	public abstract Set<Warenausgangsmeldung> getWarenausgangsmeldungen();

	@OneToMany(mappedBy = "produkt")
	public abstract Set<Bestellung> getBestellungen();

	@OneToOne(mappedBy = "produkt")
	public abstract IOrderbuch getOrderbuch();

	@OneToMany(mappedBy = "produkt")
	public abstract Set<Einkaufsinfosatz> getEinkaufsinfosaetze();

}