package aip2.m.BestellungsModul;

import java.util.Date;
import javax.persistence.*;

import aip2.m.LieferantenModul.ILieferant;
import aip2.m.LieferantenModul.Lieferant;
import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.Produkt;
import aip2.m.WarenmeldungsModul.IWareneingangsmeldung;
import aip2.m.WarenmeldungsModul.Wareneingangsmeldung;

@Entity
@Table(name = "bestellung")
public final class Bestellung implements IBestellung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bestellung_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date bestelldatum;

	private int menge;

	@Column(nullable = false)
	private boolean freigabe;

	@JoinColumn
	@ManyToOne(targetEntity = Produkt.class)
	private IProdukt produkt;

	@JoinColumn
	@OneToOne(targetEntity = Wareneingangsmeldung.class)
	private IWareneingangsmeldung wareneingangsmeldung;

	@JoinColumn
	@ManyToOne(targetEntity = Lieferant.class)
	private ILieferant lieferant;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Bestellung() {
	}

	public Bestellung(Date bestelldatum, int menge, boolean freigabe,
			IProdukt produkt, ILieferant lieferant) {
		this.bestelldatum = bestelldatum;
		this.menge = menge;
		this.freigabe = freigabe;
		this.produkt = produkt;
		this.lieferant = lieferant;
	}

	@Override
	public int getBestellNr() {
		return nr;
	}

	@Override
	public Date getBestelldatum() {
		return bestelldatum;
	}

	void setBestelldatum(Date bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	@Override
	public int getMenge() {
		return menge;
	}

	void setMenge(int menge) {
		this.menge = menge;
	}

	@Override
	public boolean isFreigabe() {
		return freigabe;
	}

	void setFreigabe(boolean freigabe) {
		this.freigabe = freigabe;
	}

	@Override
	public IProdukt getProdukt() {
		return produkt;
	}

	void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	@Override
	public IWareneingangsmeldung getWareneingangsmeldung() {
		return wareneingangsmeldung;
	}

	void setWareneingangsmeldung(IWareneingangsmeldung wareneingangsmeldung) {
		this.wareneingangsmeldung = wareneingangsmeldung;
	}

	@Override
	public ILieferant getLieferant() {
		return lieferant;
	}

	void setLieferant(ILieferant lieferant) {
		this.lieferant = lieferant;
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
		Bestellung other = (Bestellung) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bestellung [nr=" + nr + ", bestelldatum=" + bestelldatum
				+ ", menge=" + menge + ", freigabe=" + freigabe + ", produkt="
				+ produkt.getProduktNr() + ", wareneingangsmeldung="
				+ wareneingangsmeldung.getWareneingangsmeldungNr()
				+ ", lieferant=" + lieferant.getLieferantenNr() + "]";
	}

}
