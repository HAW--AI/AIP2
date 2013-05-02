package aip2.m.Interfaces;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import aip2.m.LieferantenModul.Einkaufsinfosatz;
import aip2.m.LieferantenModul.Orderbuchsatz;

public interface ILieferant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferant_nr")
	public abstract int getNr();

	public abstract String getName();

	public abstract String getAdresse();

	public abstract String getKontoverbindung();

	@OneToMany(mappedBy = "lieferant")
	public abstract Set<Einkaufsinfosatz> getEinkaufsinfosaetze();

	@OneToMany(mappedBy = "lieferant")
	public abstract Set<Orderbuchsatz> getOrderbuchsaetze();

}