package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public interface IWareneingangsmeldung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wareneingangsmeldung_nr")
	public abstract int getNr();

	public abstract long getDatum();

	public abstract int getMenge();

	@OneToOne(mappedBy = "wareneingangsmeldung")
	public abstract IBestellung getBestellung();

}