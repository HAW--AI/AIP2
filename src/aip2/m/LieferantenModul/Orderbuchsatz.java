package aip2.m.LieferantenModul;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "orderbuchsatz")
public final class Orderbuchsatz implements IOrderbuchsatz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuchsatz_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date gueltigAb;

	@Temporal(TemporalType.TIME)
	private Date gueltigBis;

	@JoinColumn
	@ManyToOne(targetEntity = Orderbuch.class)
	private IOrderbuch orderbuch;

	@JoinColumn
	@ManyToOne(targetEntity = Lieferant.class)
	private ILieferant lieferant;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Orderbuchsatz() {
	}

	public Orderbuchsatz(int nr, Date gueltigAb, Date gueltigBis,
			IOrderbuch orderbuch, ILieferant lieferant) {
		super();
		this.nr = nr;
		this.gueltigAb = gueltigAb;
		this.gueltigBis = gueltigBis;
		this.orderbuch = orderbuch;
		this.lieferant = lieferant;
	}

	@Override
	public int getOrderbuchsatzNr() {
		return nr;
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
	public IOrderbuch getOrderbuch() {
		return orderbuch;
	}

	void setOrderbuch(IOrderbuch orderbuch) {
		this.orderbuch = orderbuch;
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
		Orderbuchsatz other = (Orderbuchsatz) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orderbuchsatz [nr=" + nr + ", gueltigAb=" + gueltigAb
				+ ", gueltigBis=" + gueltigBis + ", orderbuch="
				+ orderbuch.getOrderBuchNr() + ", lieferant="
				+ lieferant.getLieferantenNr() + "]";
	}

}
