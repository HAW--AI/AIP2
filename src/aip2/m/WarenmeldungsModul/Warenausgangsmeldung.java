package aip2.m.WarenmeldungsModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.IProdukt;
import aip2.m.Interfaces.IWarenausgangsmeldung;

@Entity
@Table(name = "warenausgangsmeldung")
public class Warenausgangsmeldung implements IWarenausgangsmeldung {

	private int nr;
	private long datum;
	private int menge;
	private IProdukt produkt;

	public Warenausgangsmeldung() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWarenausgangsmeldung#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "warenausgangsmeldung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWarenausgangsmeldung#getDatum()
	 */
	@Override
	public long getDatum() {
		return datum;
	}

	public void setDatum(long datum) {
		this.datum = datum;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWarenausgangsmeldung#getMenge()
	 */
	@Override
	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IWarenausgangsmeldung#getProdukt()
	 */
	@Override
	@ManyToOne(/*mappedBy = "warenausgangsmeldungen"*/)
	public IProdukt getProdukt() {
		return produkt;
	}

	public void setProdukt(IProdukt produkt) {
		this.produkt = produkt;
	}


}
