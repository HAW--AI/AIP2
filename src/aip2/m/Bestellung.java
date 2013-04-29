package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "bestellung")
public class Bestellung implements IBestellung {

	private int nr;
	private long bestelldatum;
	private int menge;
	private boolean freigabe;
	private IProdukt produkt;
	private IWareneingangsmeldung wareneingangsmeldung;
	private ILieferant lieferant;

	public Bestellung() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bestellung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#getBestelldatum()
	 */
	@Override
	public long getBestelldatum() {
		return bestelldatum;
	}

	public void setBestelldatum(long bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#getMenge()
	 */
	@Override
	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#isFreigabe()
	 */
	@Override
	public boolean isFreigabe() {
		return freigabe;
	}

	public void setFreigabe(boolean freigabe) {
		this.freigabe = freigabe;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#getProdukt()
	 */
	@Override
	@ManyToOne(/*mappedBy = "warenausgangsmeldungen"*/)
	public IProdukt getProdukt() {
		return produkt;
	}

	public void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#getWareneingangsmeldung()
	 */
	@Override
	@OneToOne(mappedBy = "warenausgangsmeldung")
	public IWareneingangsmeldung getWareneingangsmeldung() {
		return wareneingangsmeldung;
	}

	public void setWareneingangsmeldung(IWareneingangsmeldung wareneingangsmeldung) {
		this.wareneingangsmeldung = wareneingangsmeldung;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IBestellung#getLieferant()
	 */
	@Override
	@ManyToOne(/*mappedBy = "bestellungen"*/)
	public ILieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(ILieferant lieferant) {
		this.lieferant = lieferant;
	}

}
