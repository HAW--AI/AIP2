package aip2.m;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public interface ILieferant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferant_nr")
	public abstract int getNr();

	public abstract String getName();

	public abstract String getAdresse();

	public abstract String getKontoverbindung();

	@OneToMany(mappedBy = "lieferant")
	public abstract HashSet<Einkaufsinfosatz> getEinkaufsinfosaetze();

	@OneToMany(mappedBy = "lieferant")
	public abstract HashSet<Orderbuchsatz> getOrderbuchsaetze();

}