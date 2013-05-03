package aip2.m.AngebotAuftragModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.IAuftrag;
import aip2.m.Interfaces.ILieferung;
import aip2.m.Interfaces.IRechnung;

@Entity
@Table(name = "auftrag")
public class Auftrag /*implements IAuftrag*/ {

	private int nr;
	private boolean abgeschlossen;
	private long beauftragtAm;
//	private ILieferung lieferung;
//	private IRechnung rechnung;
	private Angebot angebot;

	public Auftrag() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAuftrag#getNr()
	 */
//	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auftrag_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAuftrag#isAbgeschlossen()
	 */
//	@Override
	public boolean isAbgeschlossen() {
		return abgeschlossen;
	}

	public void setAbgeschlossen(boolean abgeschlossen) {
		this.abgeschlossen = abgeschlossen;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAuftrag#getBeauftragtAm()
	 */
//	@Override
	public long getBeauftragtAm() {
		return beauftragtAm;
	}

	public void setBeauftragtAm(long beauftragtAm) {
		this.beauftragtAm = beauftragtAm;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAuftrag#getLieferung()
	 */
//	@Override
//	@OneToOne(mappedBy = "auftrag")
//	public ILieferung getLieferung() {
//		return lieferung;
//	}
//
//	public void setLieferung(ILieferung lieferung) {
//		this.lieferung = lieferung;
//	}
//
//	/* (non-Javadoc)
//	 * @see aip2.m.IAuftrag#getRechnung()
//	 */
//	@Override
//	@OneToOne(mappedBy = "auftrag")
//	public IRechnung getRechnung() {
//		return rechnung;
//	}
//
//	public void setRechnung(IRechnung rechnung) {
//		this.rechnung = rechnung;
//	}

	/* (non-Javadoc)
	 * @see aip2.m.IAuftrag#getAngebot()
	 */
//	@Override
	@OneToOne(mappedBy = "auftrag")
	public Angebot getAngebot() {
		return angebot;
	}

	public void setAngebot(Angebot angebot) {
		this.angebot = angebot;
	}

}
