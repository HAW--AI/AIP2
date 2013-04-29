package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "produkt")
public class Produkt {

	private int nr;
	private String name;
	private int lagerbestand;
	private HashSet<Angebot> angebote;
	private HashSet<Warenausgangsmeldung> warenausgangsmeldungen;
	private HashSet<Bestellung> bestellungen;
	private Orderbuch orderbuch;
	private HashSet<Einkaufsinfosatz> einkaufsinfosaetze;

	public Produkt() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produkt_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLagerbestand() {
		return lagerbestand;
	}

	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	@ManyToMany(mappedBy = "produkte")
	public HashSet<Angebot> getAngebote() {
		return angebote;
	}

	public void setAngebote(HashSet<Angebot> angebote) {
		this.angebote = angebote;
	}

	@OneToMany(mappedBy = "produkt")
	public HashSet<Warenausgangsmeldung> getWarenausgangsmeldungen() {
		return warenausgangsmeldungen;
	}

	public void setWarenausgangsmeldungen(
			HashSet<Warenausgangsmeldung> warenausgangsmeldungen) {
		this.warenausgangsmeldungen = warenausgangsmeldungen;
	}

	@OneToMany(mappedBy = "produkt")
	public HashSet<Bestellung> getBestellungen() {
		return bestellungen;
	}

	public void setBestellungen(HashSet<Bestellung> bestellungen) {
		this.bestellungen = bestellungen;
	}

	@OneToOne(mappedBy = "produkt")
	public Orderbuch getOrderbuch() {
		return orderbuch;
	}

	public void setOrderbuch(Orderbuch orderbuch) {
		this.orderbuch = orderbuch;
	}

	@OneToMany(mappedBy = "produkt")
	public HashSet<Einkaufsinfosatz> getEinkaufsinfosaetze() {
		return einkaufsinfosaetze;
	}

	public void setEinkaufsinfosaetze(HashSet<Einkaufsinfosatz> einkaufsinfosaetze) {
		this.einkaufsinfosaetze = einkaufsinfosaetze;
	}
	
}
