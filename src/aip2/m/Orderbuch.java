package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "bestellung")
public class Orderbuch {

	private int nr;
	private Produkt produkt;
	private HashSet<Orderbuchsatz> orderbuchsaetze;

	public Orderbuch() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuch_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	@OneToOne(mappedBy = "orderbuch")
	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	@OneToMany(mappedBy = "orderbuch")
	public HashSet<Orderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	public void setOrderbuchsaetze(HashSet<Orderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
	}

}
