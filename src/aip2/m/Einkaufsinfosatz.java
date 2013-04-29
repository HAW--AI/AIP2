package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "einkaufsinfosatz")
public class Einkaufsinfosatz implements IEinkaufsinfosatz {

	private int nr;
	private long gueltigAb;
	private long gueltigBis;
	private long planlieferzeit;
	private int normalmenge;
	private int preis;
	private IProdukt produkt;
	private ILieferant lieferant;

	public Einkaufsinfosatz() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "einkaufsinfosatz_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getGueltigAb()
	 */
	@Override
	public long getGueltigAb() {
		return gueltigAb;
	}

	public void setGueltigAb(long gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getGueltigBis()
	 */
	@Override
	public long getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(long gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getPlanlieferzeit()
	 */
	@Override
	public long getPlanlieferzeit() {
		return planlieferzeit;
	}

	public void setPlanlieferzeit(long planlieferzeit) {
		this.planlieferzeit = planlieferzeit;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getNormalmenge()
	 */
	@Override
	public int getNormalmenge() {
		return normalmenge;
	}

	public void setNormalmenge(int normalmenge) {
		this.normalmenge = normalmenge;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getPreis()
	 */
	@Override
	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getProdukt()
	 */
	@Override
	@ManyToOne(/*mappedBy = "einkaufsinfosatz"*/)
	public IProdukt getProdukt() {
		return produkt;
	}

	public void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IEinkaufsinfosatz#getLieferant()
	 */
	@Override
	@ManyToOne(/*mappedBy = "einkaufsinfosatz"*/)
	public ILieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(ILieferant lieferant) {
		this.lieferant = lieferant;
	}

}
