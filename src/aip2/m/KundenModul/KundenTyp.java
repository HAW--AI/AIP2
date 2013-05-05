package aip2.m.KundenModul;

import java.util.Set;
import aip2.m.AngebotAuftragModul.IAngebot;

/**
 * Fachlicher Datentyp Kunde
 */
public class KundenTyp implements IKunde {

	private int nr;

	private String name;

	private String adresse;

	private Set<IAngebot> angebote;

	KundenTyp(int nr, String name, String adresse, Set<IAngebot> angebote) {
		this.nr = nr;
		this.name = name;
		this.adresse = adresse;
		this.angebote = angebote;
	}

	@Override
	public int getKundenNr() {
		return nr;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getAdresse() {
		return adresse;
	}

	@Override
	public Set<IAngebot> getAngebote() {
		return angebote;
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
		KundenTyp other = (KundenTyp) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KundenTyp [nr=" + nr + ", name=" + name + ", adresse="
				+ adresse + ", angebote=" + angebote + "]";
	}

}