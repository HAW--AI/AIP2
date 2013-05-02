package aip2.m.KundenModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.AngebotAuftragModul.Angebot;
import aip2.m.Interfaces.IKunde;

@Entity
@Table(name = "kunde")
public class Kunde implements IKunde {

	public Kunde(int nr, String name, String adresse, Set<Angebot> angebote) {
		super();
		this.nr = nr;
		this.name = name;
		this.adresse = adresse;
		this.angebote = angebote;
	}

	private int nr;
	private String name;
	private String adresse;
	private Set<Angebot> angebote;

	public Kunde() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IKunde#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kunde_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IKunde#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IKunde#getAdresse()
	 */
	@Override
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IKunde#getAngebote()
	 */
	@Override
	@OneToMany(mappedBy = "kunde")
	public Set<Angebot> getAngebote() {
		return angebote;
	}

	public void setAngebote(Set<Angebot> angebote) {
		this.angebote = angebote;
	}

	public void addAngebot(Angebot angebot) {
		this.angebote.add(angebot);
	}

	@Override
	public String toString() {
		return "Kunde [nr=" + nr + ", name=" + name + ", adresse=" + adresse
				 + "]";
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
		Kunde other = (Kunde) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

}
