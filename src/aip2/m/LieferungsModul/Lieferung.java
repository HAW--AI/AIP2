package aip2.m.LieferungsModul;

import javax.persistence.*;

import aip2.m.AngebotAuftragModul.Auftrag;
import aip2.m.AngebotAuftragModul.IAuftrag;

/**
 * Lieferung Entität inklusive Speicherung in der DB
 * 
 */
@Entity
@Table(name = "Lieferung")
public final class Lieferung implements ILieferung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferung_nr")
	private int nr;

	@JoinColumn
	@OneToOne(targetEntity = Transportauftrag.class)
	private ITransportauftrag transportauftrag;

	@OneToOne(mappedBy = "lieferung", targetEntity = Auftrag.class)
	private IAuftrag auftrag;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Lieferung() {
	}

	Lieferung(ITransportauftrag transportauftrag) {
		super();
		this.transportauftrag = transportauftrag;
	}

	@Override
	public int getLieferungsNr() {
		return nr;
	}

	@Override
	public ITransportauftrag getTransportauftrag() {
		return transportauftrag;
	}

	void setTransportauftrag(ITransportauftrag transportauftrag) {
		this.transportauftrag = transportauftrag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lieferung other = (Lieferung) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lieferung [nr=" + nr + ", transportauftrag=" + transportauftrag
				+ ", auftrag=" + auftrag + "]";
	}

}
