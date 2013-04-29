package aip2.m;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public interface ITransportauftrag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transportauftrag_nr")
	public abstract int getNr();

	@OneToOne(mappedBy = "transportauftrag")
	public abstract ILieferung getLieferung();

}