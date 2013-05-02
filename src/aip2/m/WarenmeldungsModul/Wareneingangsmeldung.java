package aip2.m.WarenmeldungsModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.IBestellung;
import aip2.m.Interfaces.IWareneingangsmeldung;

@Entity
@Table(name = "wareneingangsmeldung")
public class Wareneingangsmeldung implements IWareneingangsmeldung {

	private int nr;
	private long datum;
	private int menge;
	private IBestellung bestellung;

	public Wareneingangsmeldung() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWareneingangsmeldung#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wareneingangsmeldung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWareneingangsmeldung#getDatum()
	 */
	@Override
	public long getDatum() {
		return datum;
	}

	public void setDatum(long datum) {
		this.datum = datum;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWareneingangsmeldung#getMenge()
	 */
	@Override
	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWareneingangsmeldung#getBestellung()
	 */
	@Override
	@OneToOne(mappedBy = "wareneingangsmeldung")
	public IBestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(IBestellung bestellung) {
		this.bestellung = bestellung;
	}


}
