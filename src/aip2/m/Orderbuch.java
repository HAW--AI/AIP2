package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "bestellung")
public class Orderbuch implements IOrderbuch {

	private int nr;
	private IProdukt produkt;
	private HashSet<Orderbuchsatz> orderbuchsaetze;

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
	public HashSet<Orderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	public void setOrderbuchsaetze(HashSet<Orderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
	}

}
