package aip2.m.WarenmeldungsModul;

import java.util.Date;
import javax.persistence.*;

import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.Produkt;

@Entity
@Table(name = "warenausgangsmeldung")
public class Warenausgangsmeldung implements IWarenausgangsmeldung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "warenausgangsmeldung_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date datum;

	private int menge;

	@JoinColumn
	@ManyToOne(targetEntity = Produkt.class)
	private IProdukt produkt;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Warenausgangsmeldung() {
	}

	public Warenausgangsmeldung(Date datum, int menge, IProdukt produkt) {
		super();
		this.datum = datum;
		this.menge = menge;
		this.produkt = produkt;
	}

	@Override
	public int getWarenausgangsmeldungNr() {
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

	@Override
	public IProdukt getProdukt() {
		return produkt;
	}

	void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
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
		Warenausgangsmeldung other = (Warenausgangsmeldung) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Warenausgangsmeldung [nr=" + nr + ", datum=" + datum
				+ ", menge=" + menge + ", produkt=" + produkt + "]";
	}

}
