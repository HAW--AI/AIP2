package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "angebot")
public class Angebot {

	private int nr;
	private long gueltigAb;
	private long gueltigBis;
	private int gesamtpreis;
	private Auftrag auftrag;
	private Kunde kunde;
	private HashSet<Produkt> produkte;

	public Angebot() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "angebot_nr")
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

	public int getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(int gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	@OneToOne(mappedBy = "angebot")
	public Auftrag getAuftrag() {
		return auftrag;
	}

	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}

	@ManyToOne(/*mappedBy = "angebote"*/)
	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	@ManyToMany(mappedBy = "angebot")
	public HashSet<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(HashSet<Produkt> produkte) {
		this.produkte = produkte;
	}

}
