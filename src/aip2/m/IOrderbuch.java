package aip2.m;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public interface IOrderbuch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuch_nr")
	public abstract int getNr();

	@OneToOne(mappedBy = "orderbuch")
	public abstract IProdukt getProdukt();

	@OneToMany(mappedBy = "orderbuch")
	public abstract HashSet<Orderbuchsatz> getOrderbuchsaetze();

}