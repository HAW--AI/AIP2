package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public interface IZahlungseingang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zahlungseingang_nr")
	public abstract int getNr();

	@OneToOne(mappedBy = "zahlungseingang")
	public abstract IRechnung getRechnung();

}