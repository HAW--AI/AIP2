package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "orderbuchsatz")
public class Orderbuchsatz implements IOrderbuchsatz {

	private int nr;
	private long gueltigAb;
	private long gueltigBis;
	private IOrderbuch orderbuch;
	private ILieferant lieferant;

	public Orderbuchsatz() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuchsatz#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuchsatz_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuchsatz#getGueltigAb()
	 */
	@Override
	public long getGueltigAb() {
		return gueltigAb;
	}

	public void setGueltigAb(long gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuchsatz#getGueltigBis()
	 */
	@Override
	public long getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(long gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuchsatz#getOrderbuch()
	 */
	@Override
	@ManyToOne(/*mappedBy = "orderbuchsatz"*/)
	public IOrderbuch getOrderbuch() {
		return orderbuch;
	}

	public void setOrderbuch(IOrderbuch orderbuch) {
		this.orderbuch = orderbuch;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IOrderbuchsatz#getLieferant()
	 */
	@Override
	@ManyToOne(/*mappedBy = "orderbuchsatz"*/)
	public ILieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(ILieferant lieferant) {
		this.lieferant = lieferant;
	}

}
