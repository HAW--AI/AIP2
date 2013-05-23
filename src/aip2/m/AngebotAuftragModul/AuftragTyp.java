package aip2.m.AngebotAuftragModul;

import java.io.Serializable;
import java.util.Date;

/**
 * Fachlicher Datentyp Auftrag
 */
public final class AuftragTyp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nr;

	private boolean abgeschlossen;

	private Date beauftragtAm;

	private int lieferungsNr;

	private int rechnungsNr;

	private int angebotsNr;

	// private ILieferung lieferung;
	//
	// private IRechnung rechnung;
	//
	// private IAngebot angebot;

	AuftragTyp(int nr, boolean abgeschlossen, Date beauftragtAm,
			int lieferungsNr, int rechnungsNr, int angebotsNr
	/* , ILieferung lieferung, IRechnung rechnung, IAngebot angebot */) {
		this.nr = nr;
		this.abgeschlossen = abgeschlossen;
		this.beauftragtAm = beauftragtAm;
		// this.lieferung = lieferung;
		// this.rechnung = rechnung;
		// this.angebot = angebot;
		this.lieferungsNr = lieferungsNr;
		this.rechnungsNr = rechnungsNr;
		this.angebotsNr = angebotsNr;
	}

	public int getAuftragsNr() {
		return nr;
	}

	public boolean isAbgeschlossen() {
		return abgeschlossen;
	}

	public Date getBeauftragtAm() {
		return beauftragtAm;
	}

	// public ILieferung getLieferung() {
	// return lieferung;
	// }
	//
	// public IRechnung getRechnung() {
	// return rechnung;
	// }
	//
	// public IAngebot getAngebot() {
	// return angebot;
	// }

	public int getLieferungsNr() {
		return lieferungsNr;
	}

	public int getRechnungsNr() {
		return rechnungsNr;
	}

	public int getAngebotsNr() {
		return angebotsNr;
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
		AuftragTyp other = (AuftragTyp) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuftragTyp [nr=" + nr + ", abgeschlossen=" + abgeschlossen
				+ ", beauftragtAm=" + beauftragtAm + "]";
	}

}
