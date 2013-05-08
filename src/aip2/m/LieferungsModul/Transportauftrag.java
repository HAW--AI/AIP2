package aip2.m.LieferungsModul;

import java.util.Date;

import javax.persistence.*;

/**
 * Transportauftrag Entität inklusive Speicherung in der DB
 * 
 */
@Entity
@Table(name = "Transportauftrag")
public class Transportauftrag implements ITransportauftrag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transportauftrag_nr")
	private int nr;

	@OneToOne(mappedBy = "transportauftrag", targetEntity = Lieferung.class)
	private ILieferung lieferung;

	@Temporal(TemporalType.TIME)
	private Date ausgangsDatum;

	private boolean lieferungErfolgt;

	@Temporal(TemporalType.TIME)
	private Date lieferDatum;

	private String transportDienstleister;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Transportauftrag() {
	}

	Transportauftrag(Date ausgangsDatum, String transportDienstleister) {
		super();
		this.ausgangsDatum = ausgangsDatum;
		this.transportDienstleister = transportDienstleister;
	}

	@Override
	public int getTransportAuftragNr() {
		return nr;
	}

	@Override
	public ILieferung getLieferung() {
		return lieferung;
	}

	void setLieferung(ILieferung lieferung) {
		this.lieferung = lieferung;
	}

	@Override
	public Date getAusgangsDatum() {
		return ausgangsDatum;
	}

	void setAusgangsDatum(Date ausgangsDatum) {
		this.ausgangsDatum = ausgangsDatum;
	}

	@Override
	public boolean isLieferungErfolgt() {
		return lieferungErfolgt;
	}

	void setLieferungErfolgt(boolean lieferungErfolgt) {
		this.lieferungErfolgt = lieferungErfolgt;
	}

	@Override
	public Date getLieferDatum() {
		return lieferDatum;
	}

	void setLieferDatum(Date lieferDatum) {
		this.lieferDatum = lieferDatum;
	}

	@Override
	public String getTransportDienstleister() {
		return transportDienstleister;
	}

	void setTransportDienstleister(String transportDienstleister) {
		this.transportDienstleister = transportDienstleister;
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
		Transportauftrag other = (Transportauftrag) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transportauftrag [nr=" + nr + ", ausgangsDatum="
				+ ausgangsDatum + ", lieferungErfolgt=" + lieferungErfolgt
				+ ", lieferDatum=" + lieferDatum + ", transportDienstleister="
				+ transportDienstleister + "]";
	}

}
