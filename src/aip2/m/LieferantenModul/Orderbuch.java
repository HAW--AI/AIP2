package aip2.m.LieferantenModul;

import java.util.Set;
import javax.persistence.*;

import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.Produkt;

@Entity
@Table(name = "bestellung")
public class Orderbuch implements IOrderbuch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuch_nr")
	private int nr;

	@OneToOne(mappedBy = "orderbuch", targetEntity = Produkt.class)
	private IProdukt produkt;

	@OneToMany(mappedBy = "orderbuch", targetEntity = Orderbuchsatz.class)
	private Set<Orderbuchsatz> orderbuchsaetze;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Orderbuch() {
	}

	public Orderbuch(IProdukt produkt) {
		super();
		this.produkt = produkt;
	}

	@Override
	public int getOrderBuchNr() {
		return nr;
	}

	@Override
	public IProdukt getProdukt() {
		return produkt;
	}

	void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	@Override
	public Set<Orderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	void setOrderbuchsaetze(Set<Orderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
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
		Orderbuch other = (Orderbuch) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orderbuch [nr=" + nr + ", produkt=" + produkt
				+ ", orderbuchsaetze=" + orderbuchsaetze + "]";
	}

}
