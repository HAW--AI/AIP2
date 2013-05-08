package aip2.m.RechnungsModul;

import java.util.Date;

import javax.persistence.*;

//import org.hibernate.annotations.CascadeType;
//import org.hibernate.annotations.Cascade;

/**
 * Zahlungseingang Entität inklusive Speicherung in der DB
 * 
 */
@Entity
@Table(name = "Zahlungseingang")
public final class Zahlungseingang implements IZahlungseingang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zahlungseingang_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date eingangsDatum;

	private int betragCent;

	@JoinColumn
	@ManyToOne(targetEntity = Rechnung.class)
	// @Cascade({ CascadeType.SAVE_UPDATE })
	private IRechnung rechnung;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Zahlungseingang() {
	}

	Zahlungseingang(Date eingangsDatum, int betragCent) {
		this.eingangsDatum = eingangsDatum;
		this.betragCent = betragCent;
	}

	@Override
	public int getZahlungseingangNr() {
		return nr;
	}

	@Override
	public Date getEingangsDatum() {
		return eingangsDatum;
	}

	void setEingangsDatum(Date eingangsDatum) {
		this.eingangsDatum = eingangsDatum;
	}

	@Override
	public int getBetragCent() {
		return betragCent;
	}

	void setBetragCent(int betragCent) {
		this.betragCent = betragCent;
	}

	@Override
	public IRechnung getRechnung() {
		return rechnung;
	}

	void setRechnung(IRechnung rechnung) {
		this.rechnung = rechnung;
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
		Zahlungseingang other = (Zahlungseingang) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zahlungseingang [nr=" + nr + ", eingangsDatum=" + eingangsDatum
				+ ", betragCent=" + betragCent + ", rechnung="
				+ rechnung.getRechnungsNr() + "]";
	}

}
