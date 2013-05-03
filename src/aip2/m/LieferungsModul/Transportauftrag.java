package aip2.m.LieferungsModul;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "transportauftrag")
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

	public Transportauftrag(int nr, ILieferung lieferung, Date ausgangsDatum,
			boolean lieferungErfolgt, Date lieferDatum,
			String transportDienstleister) {
		super();
		this.nr = nr;
		this.lieferung = lieferung;
		this.ausgangsDatum = ausgangsDatum;
		this.lieferungErfolgt = lieferungErfolgt;
		this.lieferDatum = lieferDatum;
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

	public Date getAusgangsDatum() {
		return ausgangsDatum;
	}

	void setAusgangsDatum(Date ausgangsDatum) {
		this.ausgangsDatum = ausgangsDatum;
	}

	public boolean isLieferungErfolgt() {
		return lieferungErfolgt;
	}

	void setLieferungErfolgt(boolean lieferungErfolgt) {
		this.lieferungErfolgt = lieferungErfolgt;
	}

	public Date getLieferDatum() {
		return lieferDatum;
	}

	void setLieferDatum(Date lieferDatum) {
		this.lieferDatum = lieferDatum;
	}

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
		return "Transportauftrag [nr=" + nr + ", lieferung=" + lieferung
				+ ", ausgangsDatum=" + ausgangsDatum + ", lieferungErfolgt="
				+ lieferungErfolgt + ", lieferDatum=" + lieferDatum
				+ ", transportDienstleister=" + transportDienstleister + "]";
	}

}
