package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public interface IAuftrag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auftrag_nr")
	public abstract int getNr();

	public abstract boolean isAbgeschlossen();

	public abstract long getBeauftragtAm();

	@OneToOne(mappedBy = "auftrag")
	public abstract ILieferung getLieferung();

	@OneToOne(mappedBy = "auftrag")
	public abstract IRechnung getRechnung();

	@OneToOne(mappedBy = "auftrag")
	public abstract IAngebot getAngebot();

}