package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "orderbuchsatz")
public class Orderbuchsatz {

	private int nr;
	private long gueltigAb;
	private long gueltigBis;
	private Orderbuch orderbuch;
	private Lieferant lieferant;

	public Orderbuchsatz() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderbuchsatz_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public long getGueltigAb() {
		return gueltigAb;
	}

	public void setGueltigAb(long gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	public long getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(long gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	@ManyToOne(/*mappedBy = "orderbuchsatz"*/)
	public Orderbuch getOrderbuch() {
		return orderbuch;
	}

	public void setOrderbuch(Orderbuch orderbuch) {
		this.orderbuch = orderbuch;
	}

	@ManyToOne(/*mappedBy = "orderbuchsatz"*/)
	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

}
