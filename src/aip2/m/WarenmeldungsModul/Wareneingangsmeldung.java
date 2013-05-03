package aip2.m.WarenmeldungsModul;

import java.util.Date;
import javax.persistence.*;

import aip2.m.BestellungsModul.Bestellung;
import aip2.m.BestellungsModul.IBestellung;

@Entity
@Table(name = "wareneingangsmeldung")
public class Wareneingangsmeldung implements IWareneingangsmeldung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wareneingangsmeldung_nr")
	private int nr;

	private Date datum;

	private int menge;

	private String Lieferschein;

	@OneToOne(mappedBy = "wareneingangsmeldung", targetEntity = Bestellung.class)
	private IBestellung bestellung;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Wareneingangsmeldung() {
	}

	public Wareneingangsmeldung(Date datum, int menge, String lieferschein,
			IBestellung bestellung) {
		super();
		this.datum = datum;
		this.menge = menge;
		Lieferschein = lieferschein;
		this.bestellung = bestellung;
	}

	@Override
	public int getWareneingangsmeldungNr() {
		return nr;
	}

	@Override
	public Date getDatum() {
		return datum;
	}

	void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public int getMenge() {
		return menge;
	}

	void setMenge(int menge) {
		this.menge = menge;
	}

	public String getLieferschein() {
		return Lieferschein;
	}

	void setLieferschein(String lieferschein) {
		Lieferschein = lieferschein;
	}

	@Override
	public IBestellung getBestellung() {
		return bestellung;
	}

	void setBestellung(IBestellung bestellung) {
		this.bestellung = bestellung;
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
		Wareneingangsmeldung other = (Wareneingangsmeldung) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wareneingangsmeldung [nr=" + nr + ", datum=" + datum
				+ ", menge=" + menge + ", Lieferschein=" + Lieferschein
				+ ", bestellung=" + bestellung + "]";
	}

}
