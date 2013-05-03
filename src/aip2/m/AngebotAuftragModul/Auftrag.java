package aip2.m.AngebotAuftragModul;

import java.util.Date;
import javax.persistence.*;

import aip2.m.LieferungsModul.ILieferung;
import aip2.m.LieferungsModul.Lieferung;
import aip2.m.RechnungsModul.IRechnung;
import aip2.m.RechnungsModul.Rechnung;

@Entity
@Table(name = "auftrag")
public class Auftrag implements IAuftrag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auftrag_nr")
	private int nr;

	private boolean abgeschlossen;
	
	@Temporal(TemporalType.TIME)
	private Date beauftragtAm;
	
	@JoinColumn
	@OneToOne(targetEntity = Lieferung.class)
	private ILieferung lieferung;

	@JoinColumn
	@OneToOne(targetEntity = Rechnung.class)
	private IRechnung rechnung;

	@JoinColumn
	@OneToOne(targetEntity = Angebot.class)
	private IAngebot angebot;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Auftrag() {
	}

	public Auftrag(int nr, Date beauftragtAm, IAngebot angebot) {
		super();
		this.nr = nr;
		this.beauftragtAm = beauftragtAm;
		this.angebot = angebot;
		this.abgeschlossen = false;
	}

	@Override
	public int getAuftragsNr() {
		return nr;
	}

	@Override
	public boolean isAbgeschlossen() {
		return abgeschlossen;
	}

	void setAbgeschlossen(boolean abgeschlossen) {
		this.abgeschlossen = abgeschlossen;
	}

	@Override
	public Date getBeauftragtAm() {
		return beauftragtAm;
	}

	void setBeauftragtAm(Date beauftragtAm) {
		this.beauftragtAm = beauftragtAm;
	}

	@Override
	public ILieferung getLieferung() {
		return lieferung;
	}

	void setLieferung(ILieferung lieferung) {
		this.lieferung = lieferung;
	}

	@Override
	public IRechnung getRechnung() {
		return rechnung;
	}

	void setRechnung(IRechnung rechnung) {
		this.rechnung = rechnung;
	}

	@Override
	public IAngebot getAngebot() {
		return angebot;
	}

	void setAngebotI(Angebot angebot) {
		this.angebot = angebot;
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
		Auftrag other = (Auftrag) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auftrag [nr=" + nr + ", abgeschlossen=" + abgeschlossen
				+ ", beauftragtAm=" + beauftragtAm + ", lieferung=" + lieferung
				+ ", rechnung=" + rechnung + ", angebot=" + angebot + "]";
	}

}
