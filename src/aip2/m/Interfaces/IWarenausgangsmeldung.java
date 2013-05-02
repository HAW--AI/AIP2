package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public interface IWarenausgangsmeldung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "warenausgangsmeldung_nr")
	public abstract int getNr();

	public abstract long getDatum();

	public abstract int getMenge();

	@ManyToOne(/*mappedBy = "warenausgangsmeldungen"*/)
	public abstract IProdukt getProdukt();

}