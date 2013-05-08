package aip2.m.LieferantenModul;

import java.util.Date;

import javax.persistence.*;

import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.Produkt;

@Entity
@Table(name = "einkaufsinfosatz")
public final class Einkaufsinfosatz implements IEinkaufsinfosatz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "einkaufsinfosatz_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date gueltigAb;

	@Temporal(TemporalType.TIME)
	private Date gueltigBis;

	private int planlieferzeit;

	private int normalmenge;

	private int preis;

	@JoinColumn
	@ManyToOne(targetEntity = Produkt.class)
	private IProdukt produkt;

	@JoinColumn
	@ManyToOne(targetEntity = Lieferant.class)
	private ILieferant lieferant;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Einkaufsinfosatz() {
	}

	@Override
	public int getEinkaufsinfosatzNr() {
		return nr;
	}

	public Einkaufsinfosatz(int nr, Date gueltigAb, Date gueltigBis,
			int planlieferzeit, int normalmenge, int preis, IProdukt produkt,
			ILieferant lieferant) {
		super();
		this.nr = nr;
		this.gueltigAb = gueltigAb;
		this.gueltigBis = gueltigBis;
		this.planlieferzeit = planlieferzeit;
		this.normalmenge = normalmenge;
		this.preis = preis;
		this.produkt = produkt;
		this.lieferant = lieferant;
	}

	@Override
	public Date getGueltigAb() {
		return gueltigAb;
	}

	void setGueltigAb(Date gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	@Override
	public Date getGueltigBis() {
		return gueltigBis;
	}

	void setGueltigBis(Date gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	@Override
	public int getPlanlieferzeit() {
		return planlieferzeit;
	}

	void setPlanlieferzeit(int planlieferzeit) {
		this.planlieferzeit = planlieferzeit;
	}

	@Override
	public int getNormalmenge() {
		return normalmenge;
	}

	void setNormalmenge(int normalmenge) {
		this.normalmenge = normalmenge;
	}

	@Override
	public int getPreis() {
		return preis;
	}

	void setPreis(int preis) {
		this.preis = preis;
	}

	@Override
	public IProdukt getProdukt() {
		return produkt;
	}

	void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	@Override
	public ILieferant getLieferant() {
		return lieferant;
	}

	void setLieferant(ILieferant lieferant) {
		this.lieferant = lieferant;
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
		Einkaufsinfosatz other = (Einkaufsinfosatz) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Einkaufsinfosatz [nr=" + nr + ", gueltigAb=" + gueltigAb
				+ ", gueltigBis=" + gueltigBis + ", planlieferzeit="
				+ planlieferzeit + ", normalmenge=" + normalmenge + ", preis="
				+ preis + ", produkt=" + produkt.getProduktNr()
				+ ", lieferant=" + lieferant.getLieferantenNr() + "]";
	}

}
