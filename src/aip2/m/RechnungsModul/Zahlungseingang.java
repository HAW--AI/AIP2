package aip2.m.RechnungsModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.IRechnung;
import aip2.m.Interfaces.IZahlungseingang;

@Entity
@Table(name = "zahlungseingang")
public class Zahlungseingang implements IZahlungseingang {

	private int nr;
	private IRechnung rechnung;

	public Zahlungseingang() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IZahlungseingang#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zahlungseingang_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IZahlungseingang#getRechnung()
	 */
	@Override
	@OneToOne(mappedBy = "zahlungseingang")
	public IRechnung getRechnung() {
		return rechnung;
	}
	public void setRechnung(IRechnung rechnung) {
		this.rechnung = rechnung;
	}

}
