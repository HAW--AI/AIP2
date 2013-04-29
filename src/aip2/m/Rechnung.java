package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "rechnung")
public class Rechnung implements IRechnung {

	private int nr;
	private HashSet<Zahlungseingang> zahlungseingaenge;
	private IAuftrag auftrag;

	public Rechnung() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IRechnung#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rechnung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IRechnung#getAuftrag()
	 */
	@Override
	@OneToOne(mappedBy = "rechnung")
	public IAuftrag getAuftrag() {
		return auftrag;
	}
	public void setAuftrag(IAuftrag auftrag) {
		this.auftrag = auftrag;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IRechnung#getZahlungseingaenge()
	 */
	@Override
	@OneToMany(mappedBy = "rechnung")
	public HashSet<Zahlungseingang> getZahlungseingaenge() {
		return zahlungseingaenge;
	}

	public void setZahlungseingaenge(HashSet<Zahlungseingang> zahlungseingaenge) {
		this.zahlungseingaenge = zahlungseingaenge;
	}

	public void addZahlungseingang(Zahlungseingang zahlungseingang) {
		this.zahlungseingaenge.add(zahlungseingang);
	}


}
