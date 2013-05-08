package aip2.m.KundenModul;

import javax.persistence.*;

/**
 * Kunden Entität inklusive Speicherung in der DB
 * 
 */
@Entity
@Table(name = "Kunde")
public final class Kunde implements IKunde {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kunde_nr")
	private int nr;

	@Column(nullable = false)
	private String name;

	private String adresse;

	// @OneToMany(mappedBy = "kunde", targetEntity = Angebot.class)
	// private Set<IAngebot> angebote;

	Kunde(String name, String adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
		// this.angebote = new HashSet<IAngebot>();
	}

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Kunde() {
	}

	@Override
	public int getKundenNr() {
		return nr;
	}

	@Override
	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAdresse() {
		return adresse;
	}

	void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	// @Override
	// public Set<IAngebot> getAngebote() {
	// return Collections.unmodifiableSet(angebote);
	// }
	//
	// void setAngebote(Set<IAngebot> angebote) {
	// this.angebote = angebote;
	// }
	//
	// boolean addAngebot(IAngebot angebot) {
	// this.angebote.add(angebot);
	// return true;
	// }

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
