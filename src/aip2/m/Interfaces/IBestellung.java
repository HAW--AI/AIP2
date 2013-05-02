package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public interface IBestellung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bestellung_nr")
	public abstract int getNr();

	public abstract long getBestelldatum();

	public abstract int getMenge();

	public abstract boolean isFreigabe();

	@ManyToOne(/*mappedBy = "warenausgangsmeldungen"*/)
	public abstract IProdukt getProdukt();

	@OneToOne(mappedBy = "warenausgangsmeldung")
	public abstract IWareneingangsmeldung getWareneingangsmeldung();

	@ManyToOne(/*mappedBy = "bestellungen"*/)
	public abstract ILieferant getLieferant();

}