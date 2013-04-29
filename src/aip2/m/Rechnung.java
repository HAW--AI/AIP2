package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "rechnung")
public class Rechnung {

	private int nr;
	private HashSet<Zahlungseingang> zahlungseingaenge;
	private Auftrag auftrag;

	public Rechnung() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rechnung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	@OneToOne(mappedBy = "rechnung")
	public Auftrag getAuftrag() {
		return auftrag;
	}
	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}

	@OneToMany(mappedBy = "rechnung")
	public HashSet<Zahlungseingang> getZahlungseingaenge() {
		return zahlungseingaenge;
	}

	public void setZahlungseingaenge(HashSet<Zahlungseingang> zahlungseingaenge) {
		this.zahlungseingaenge = zahlungseingaenge;
	}

	public void addZahlungseingang(Zahlungseingang zahlungseingang) {
		this.zahlungseingaenge.add(zahlungseingang);
	}


}
