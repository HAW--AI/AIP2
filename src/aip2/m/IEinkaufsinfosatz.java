package aip2.m;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public interface IEinkaufsinfosatz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "einkaufsinfosatz_nr")
	public abstract int getNr();

	public abstract long getGueltigAb();

	public abstract long getGueltigBis();

	public abstract long getPlanlieferzeit();

	public abstract int getNormalmenge();

	public abstract int getPreis();

	@ManyToOne(/*mappedBy = "einkaufsinfosatz"*/)
	public abstract IProdukt getProdukt();

	@ManyToOne(/*mappedBy = "einkaufsinfosatz"*/)
	public abstract ILieferant getLieferant();

}