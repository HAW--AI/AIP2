package aip2.m.LieferantenModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.IOrderbuch;
import aip2.m.Interfaces.IProdukt;

@Entity
@Table(name = "bestellung")
public class Orderbuch implements IOrderbuch {

	private int nr;
	private IProdukt produkt;
	private Set<Orderbuchsatz> orderbuchsaetze;

	public Orderbuch() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuch#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuch_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuch#getProdukt()
	 */
	@Override
	@OneToOne(mappedBy = "orderbuch")
	public IProdukt getProdukt() {
		return produkt;
	}

	public void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuch#getOrderbuchsaetze()
	 */
	@Override
	@OneToMany(mappedBy = "orderbuch")
	public Set<Orderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	public void setOrderbuchsaetze(Set<Orderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
	}

}
