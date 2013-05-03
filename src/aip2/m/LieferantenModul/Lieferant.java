package aip2.m.LieferantenModul;

import java.util.Set;
import javax.persistence.*;

import aip2.m.BestellungsModul.Bestellung;
import aip2.m.BestellungsModul.IBestellung;

@Entity
@Table(name = "lieferant")
public class Lieferant implements ILieferant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferant_nr")
	private int nr;

	private String name;

	private String adresse;

	private String kontoverbindung;

	@OneToMany(mappedBy = "lieferant", targetEntity = Einkaufsinfosatz.class)
	private Set<IEinkaufsinfosatz> einkaufsinfosaetze;

	@OneToMany(mappedBy = "lieferant", targetEntity = Orderbuchsatz.class)
	private Set<IOrderbuchsatz> orderbuchsaetze;

	@OneToMany(mappedBy = "lieferant", targetEntity = Bestellung.class)
	private Set<IBestellung> bestellungen;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Lieferant() {
	}

	public Lieferant(String name, String adresse,
			String kontoverbindung, Set<IEinkaufsinfosatz> einkaufsinfosaetze) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.kontoverbindung = kontoverbindung;
		this.einkaufsinfosaetze = einkaufsinfosaetze;
	}

	@Override
	public int getLieferantenNr() {
		return nr;
	}

	@Override
	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAdresse() {
		return adresse;
	}

	void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String getKontoverbindung() {
		return kontoverbindung;
	}

	void setKontoverbindung(String kontoverbindung) {
		this.kontoverbindung = kontoverbindung;
	}

	@Override
	public Set<IEinkaufsinfosatz> getEinkaufsinfosaetze() {
		return einkaufsinfosaetze;
	}

	void setEinkaufsinfosaetze(Set<IEinkaufsinfosatz> einkaufsinfosaetze) {
		this.einkaufsinfosaetze = einkaufsinfosaetze;
	}

	@Override
	public Set<IOrderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	void setOrderbuchsaetze(Set<IOrderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
	}

	public Set<IBestellung> getBestellungen() {
		return bestellungen;
	}

	void setBestellungen(Set<IBestellung> bestellungen) {
		this.bestellungen = bestellungen;
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
		Lieferant other = (Lieferant) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lieferant [nr=" + nr + ", name=" + name + ", adresse="
				+ adresse + ", kontoverbindung=" + kontoverbindung
				+ ", einkaufsinfosaetze=" + einkaufsinfosaetze
				+ ", orderbuchsaetze=" + orderbuchsaetze + "]";
	}

}
