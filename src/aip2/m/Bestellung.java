package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "bestellung")
public class Bestellung {

	private int nr;
	private long bestelldatum;
	private int menge;
	private boolean freigabe;
	private Produkt produkt;
	private Wareneingangsmeldung wareneingangsmeldung;
	private Lieferant lieferant;

	public Bestellung() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bestellung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public long getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(long bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public boolean isFreigabe() {
		return freigabe;
	}

	public void setFreigabe(boolean freigabe) {
		this.freigabe = freigabe;
	}

	@ManyToOne(/*mappedBy = "warenausgangsmeldungen"*/)
	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	@OneToOne(mappedBy = "warenausgangsmeldung")
	public Wareneingangsmeldung getWareneingangsmeldung() {
		return wareneingangsmeldung;
	}

	public void setWareneingangsmeldung(Wareneingangsmeldung wareneingangsmeldung) {
		this.wareneingangsmeldung = wareneingangsmeldung;
	}

	@ManyToOne(/*mappedBy = "bestellungen"*/)
	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

}
