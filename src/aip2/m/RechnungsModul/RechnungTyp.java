package aip2.m.RechnungsModul;

import java.io.Serializable;
import java.util.Date;

public final class RechnungTyp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nr;

	private Date rechnungsDatum;

	private int preis;

	private boolean istBezahlt;

	private int auftragNr;

	RechnungTyp(int nr, Date rechnungsDatum, int preis, boolean istBezahlt,
			int auftragNr) {
		this.nr = nr;
		this.rechnungsDatum = rechnungsDatum;
		this.preis = preis;
		this.istBezahlt = istBezahlt;
		this.auftragNr = auftragNr;
	}

	public int getNr() {
		return nr;
	}

	public Date getRechnungsDatum() {
		return rechnungsDatum;
	}

	public int getPreis() {
		return preis;
	}

	public boolean isIstBezahlt() {
		return istBezahlt;
	}

	public int getAuftragNr() {
		return auftragNr;
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
		RechnungTyp other = (RechnungTyp) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RechnungTyp [nr=" + nr + ", rechnungsDatum=" + rechnungsDatum
				+ ", preis=" + preis + ", istBezahlt=" + istBezahlt
				+ ", auftragNr=" + auftragNr + "]";
	}

}
