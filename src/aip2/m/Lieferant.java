package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "lieferant")
public class Lieferant {

	private int nr;
	private String name;
	private String adresse;
	private String kontoverbindung;
	private HashSet<Einkaufsinfosatz> einkaufsinfosaetze;
	private HashSet<Orderbuchsatz> orderbuchsaetze;

	public Lieferant() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferant_nr")
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getKontoverbindung() {
		return kontoverbindung;
	}

	public void setKontoverbindung(String kontoverbindung) {
		this.kontoverbindung = kontoverbindung;
	}

	@OneToMany(mappedBy = "lieferant")
	public HashSet<Einkaufsinfosatz> getEinkaufsinfosaetze() {
		return einkaufsinfosaetze;
	}

	public void setEinkaufsinfosaetze(HashSet<Einkaufsinfosatz> einkaufsinfosaetze) {
		this.einkaufsinfosaetze = einkaufsinfosaetze;
	}

	@OneToMany(mappedBy = "lieferant")
	public HashSet<Orderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	public void setOrderbuchsaetze(HashSet<Orderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
	}

}
