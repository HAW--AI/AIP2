package aip2.m.ProduktModul;

import java.util.Set;
import javax.persistence.*;

import aip2.m.AngebotAuftragModul.Angebot;
import aip2.m.AngebotAuftragModul.IAngebot;
import aip2.m.BestellungsModul.Bestellung;
import aip2.m.BestellungsModul.IBestellung;
import aip2.m.LieferantenModul.Einkaufsinfosatz;
import aip2.m.LieferantenModul.IEinkaufsinfosatz;
import aip2.m.LieferantenModul.IOrderbuch;
import aip2.m.LieferantenModul.Orderbuch;
import aip2.m.WarenmeldungsModul.IWarenausgangsmeldung;
import aip2.m.WarenmeldungsModul.Warenausgangsmeldung;

@Entity
@Table(name = "produkt")
public class Produkt implements IProdukt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produkt_nr")
	private int nr;

	private String name;

	private int lagerbestand;

	//TODO
	@Transient
	@ManyToMany(mappedBy = "produkte", targetEntity = Angebot.class)
	private Set<IAngebot> angebote;

	@OneToMany(targetEntity = Warenausgangsmeldung.class)
	private Set<IWarenausgangsmeldung> warenausgangsmeldungen;

	@OneToMany(mappedBy = "produkt", targetEntity = Bestellung.class)
	private Set<IBestellung> bestellungen;

	@JoinColumn
	@OneToOne(targetEntity = Orderbuch.class)
	private IOrderbuch orderbuch;

	@OneToMany(mappedBy = "produkt", targetEntity = Einkaufsinfosatz.class)
	private Set<IEinkaufsinfosatz> einkaufsinfosaetze;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Produkt() {
	}

	public Produkt(String name, int lagerbestand, IOrderbuch orderbuch) {
		super();
		this.name = name;
		this.lagerbestand = lagerbestand;
		this.orderbuch = orderbuch;
	}

	@Override
	public int getProduktNr() {
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
	public int getLagerbestand() {
		return lagerbestand;
	}

	void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	@Override
	public Set<IAngebot> getAngebote() {
		return angebote;
	}

	void setAngebote(Set<IAngebot> angebote) {
		this.angebote = angebote;
	}

	@Override
	public Set<IWarenausgangsmeldung> getWarenausgangsmeldungen() {
		return warenausgangsmeldungen;
	}

	void setWarenausgangsmeldungen(
			Set<IWarenausgangsmeldung> warenausgangsmeldungen) {
		this.warenausgangsmeldungen = warenausgangsmeldungen;
	}

	@Override
	public Set<IBestellung> getBestellungen() {
		return bestellungen;
	}

	void setBestellungen(Set<IBestellung> bestellungen) {
		this.bestellungen = bestellungen;
	}

	@Override
	public IOrderbuch getOrderbuch() {
		return orderbuch;
	}

	void setOrderbuch(IOrderbuch orderbuch) {
		this.orderbuch = orderbuch;
	}

	@Override
	public Set<IEinkaufsinfosatz> getEinkaufsinfosaetze() {
		return einkaufsinfosaetze;
	}

	void setEinkaufsinfosaetze(Set<IEinkaufsinfosatz> einkaufsinfosaetze) {
		this.einkaufsinfosaetze = einkaufsinfosaetze;
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
		Produkt other = (Produkt) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produkt [nr=" + nr + ", name=" + name + ", lagerbestand="
				+ lagerbestand + ", warenausgangsmeldungen="
				+ warenausgangsmeldungen + ", bestellungen=" + bestellungen
				+ ", orderbuch=" + orderbuch + ", einkaufsinfosaetze="
				+ einkaufsinfosaetze + "]";
	}

}
