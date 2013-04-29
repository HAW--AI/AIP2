package aip2.m;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public interface IRechnung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rechnung_nr")
	public abstract int getNr();

	@OneToOne(mappedBy = "rechnung")
	public abstract IAuftrag getAuftrag();

	@OneToMany(mappedBy = "rechnung")
	public abstract HashSet<Zahlungseingang> getZahlungseingaenge();

}