package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public interface IOrderbuchsatz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuchsatz_nr")
	public abstract int getNr();

	public abstract long getGueltigAb();

	public abstract long getGueltigBis();

	@ManyToOne(/*mappedBy = "orderbuchsatz"*/)
	public abstract IOrderbuch getOrderbuch();

	@ManyToOne(/*mappedBy = "orderbuchsatz"*/)
	public abstract ILieferant getLieferant();

}