package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "einkaufsinfosatz")
public class Einkaufsinfosatz {

	private int nr;
	private long gueltigAb;
	private long gueltigBis;
	private long planlieferzeit;
	private int normalmenge;
	private int preis;
	private Produkt produkt;
	private Lieferant lieferant;

	public Einkaufsinfosatz() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "einkaufsinfosatz_nr")
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

	public long getPlanlieferzeit() {
		return planlieferzeit;
	}

	public void setPlanlieferzeit(long planlieferzeit) {
		this.planlieferzeit = planlieferzeit;
	}

	public int getNormalmenge() {
		return normalmenge;
	}

	public void setNormalmenge(int normalmenge) {
		this.normalmenge = normalmenge;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	@ManyToOne(/*mappedBy = "einkaufsinfosatz"*/)
	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	@ManyToOne(/*mappedBy = "einkaufsinfosatz"*/)
	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

}
