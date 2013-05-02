package aip2.m.Interfaces;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public interface ILieferung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferung_nr")
	public abstract int getNr();

	@OneToOne(mappedBy = "lieferung")
	public abstract IAuftrag getAuftrag();

	@OneToOne(mappedBy = "lieferung")
	public abstract ITransportauftrag getTransportauftrag();

}