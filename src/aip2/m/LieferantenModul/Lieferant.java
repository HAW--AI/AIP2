package aip2.m.LieferantenModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.ILieferant;

@Entity
@Table(name = "lieferant")
public class Lieferant implements ILieferant {

	private int nr;
	private String name;
	private String adresse;
	private String kontoverbindung;
	private Set<Einkaufsinfosatz> einkaufsinfosaetze;
	private Set<Orderbuchsatz> orderbuchsaetze;

	public Lieferant() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferant#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferant_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferant#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferant#getAdresse()
	 */
	@Override
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferant#getKontoverbindung()
	 */
	@Override
	public String getKontoverbindung() {
		return kontoverbindung;
	}

	public void setKontoverbindung(String kontoverbindung) {
		this.kontoverbindung = kontoverbindung;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferant#getEinkaufsinfosaetze()
	 */
	@Override
	@OneToMany(mappedBy = "lieferant")
	public Set<Einkaufsinfosatz> getEinkaufsinfosaetze() {
		return einkaufsinfosaetze;
	}

	public void setEinkaufsinfosaetze(Set<Einkaufsinfosatz> einkaufsinfosaetze) {
		this.einkaufsinfosaetze = einkaufsinfosaetze;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferant#getOrderbuchsaetze()
	 */
	@Override
	@OneToMany(mappedBy = "lieferant")
	public Set<Orderbuchsatz> getOrderbuchsaetze() {
		return orderbuchsaetze;
	}

	public void setOrderbuchsaetze(Set<Orderbuchsatz> orderbuchsaetze) {
		this.orderbuchsaetze = orderbuchsaetze;
	}

}
