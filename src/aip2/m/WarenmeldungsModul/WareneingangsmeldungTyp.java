package aip2.m.WarenmeldungsModul;

import java.util.Date;

import aip2.m.BestellungsModul.IBestellung;

public class WareneingangsmeldungTyp {

	private int wareneingangsmeldungNr;
	private Date datum;
	private int menge;
	private String lieferschein;
	private IBestellung bestellung;
	public WareneingangsmeldungTyp(int wareneingangsmeldungNr, Date datum,
			int menge, String lieferschein, IBestellung bestellung) {
		super();
		this.wareneingangsmeldungNr = wareneingangsmeldungNr;
		this.datum = datum;
		this.menge = menge;
		this.lieferschein = lieferschein;
		this.bestellung = bestellung;
	}
	public int getWareneingangsmeldungNr() {
		return wareneingangsmeldungNr;
	}
	public Date getDatum() {
		return datum;
	}
	public int getMenge() {
		return menge;
	}
	public String getLieferschein() {
		return lieferschein;
	}
	public IBestellung getBestellung() {
		return bestellung;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + wareneingangsmeldungNr;
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
		WareneingangsmeldungTyp other = (WareneingangsmeldungTyp) obj;
		if (wareneingangsmeldungNr != other.wareneingangsmeldungNr)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WareneingangsmeldungTyp [wareneingangsmeldungNr="
				+ wareneingangsmeldungNr + ", datum=" + datum + ", menge="
				+ menge + ", lieferschein=" + lieferschein + ", bestellung="
				+ bestellung + "]";
	}
	

}
