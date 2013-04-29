package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "kunde")
public class Kunde {

	private int nr;
	private String name;
	private String adresse;
	private HashSet<Angebot> angebote;

	public Kunde() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kunde_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@OneToMany(mappedBy = "kunde")
	public HashSet<Angebot> getAngebote() {
		return angebote;
	}

	public void setAngebote(HashSet<Angebot> angebote) {
		this.angebote = angebote;
	}

	public void setAngebote(Angebot angebot) {
		this.angebote.add(angebot);
	}

}
