package aip2.m.AngebotAuftragModul;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import aip2.m.ProduktModul.IProdukt;

/**
 * MAYBE I DONT KNOW
 * 
 */
@Entity
@Table(name = "produktMenge")
public class ProduktMengeTyp implements IProduktMenge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produktMenge")
	private int nr;
	
	//To do @OneToMany(mappedBy = "produkte", targetEntity = Angebot.class)
	private IProdukt produkt;
	
	private int menge;

	public ProduktMengeTyp(IProdukt produkt, int menge) {
		super();
		this.produkt = produkt;
		this.menge = menge;
	}

	@Override
	public IProdukt getProdukt() {
		return produkt;
	}

	void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	@Override
	public int getMenge() {
		return menge;
	}

	void setMenge(int menge) {
		this.menge = menge;
	}

	@Override
	public int getNr() {
		return nr;
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
		ProduktMengeTyp other = (ProduktMengeTyp) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProduktMengeTyp [nr=" + nr + ", produkt=" + produkt
				+ ", menge=" + menge + "]";
	}

}
