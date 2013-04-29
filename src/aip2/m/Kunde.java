package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "kunde")
public class Kunde implements IKunde {

	private int nr;
	private String name;
	private String adresse;
	private HashSet<Angebot> angebote;

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
	public HashSet<Angebot> getAngebote() {
		return angebote;
	}

	public void setAngebote(HashSet<Angebot> angebote) {
		this.angebote = angebote;
	}

	public void addAngebot(Angebot angebot) {
		this.angebote.add(angebot);
	}

}
