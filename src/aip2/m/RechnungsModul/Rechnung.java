package aip2.m.RechnungsModul;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import aip2.m.AngebotAuftragModul.Auftrag;
import aip2.m.AngebotAuftragModul.IAuftrag;

@Entity
@Table(name = "Rechnung")
public class Rechnung implements IRechnung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rechnung_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date rechnungsDatum;

	private int preis;
	private boolean istBezahlt;

	@OneToMany(mappedBy = "rechnung", targetEntity = Zahlungseingang.class)
	private Set<Zahlungseingang> zahlungseingaenge;

	@Cascade({CascadeType.SAVE_UPDATE})
	@OneToOne(mappedBy = "rechnung", targetEntity = Auftrag.class)
	// TODO: Unnötige Entitäten bei allen entfernen
	private IAuftrag auftrag;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Rechnung() {
	}

	Rechnung(Date rechnungsDatum, boolean istBezahlt, IAuftrag auftrag) {
		super();
		this.rechnungsDatum = rechnungsDatum;
		this.istBezahlt = istBezahlt;
		this.auftrag = auftrag;
		this.preis = auftrag.getAngebot().getGesamtpreis();
	}

	@Override
	public int getRechnungsNr() {
		return nr;
	}

	@Override
	public Date getRechnungsDatum() {
		return rechnungsDatum;
	}

	void setRechnungsDatum(Date rechnungsDatum) {
		this.rechnungsDatum = rechnungsDatum;
	}

	@Override
	public boolean isIstBezahlt() {
		return istBezahlt;
	}

	void setIstBezahlt(boolean istBezahlt) {
		this.istBezahlt = istBezahlt;
	}

	@Override
	public IAuftrag getAuftrag() {
		return auftrag;
	}

	void setAuftrag(IAuftrag auftrag) {
		this.auftrag = auftrag;
	}

	@Override
	public Set<Zahlungseingang> getZahlungseingaenge() {
		return zahlungseingaenge;
	}

	void setZahlungseingaenge(Set<Zahlungseingang> zahlungseingaenge) {
		this.zahlungseingaenge = zahlungseingaenge;
	}

	void addZahlungseingang(Zahlungseingang zahlungseingang) {
		this.zahlungseingaenge.add(zahlungseingang);
	}

	public int getPreis() {
		return preis;
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
		Rechnung other = (Rechnung) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rechnung [nr=" + nr + ", rechnungsDatum=" + rechnungsDatum
				+ ", istBezahlt=" + istBezahlt + ", zahlungseingaenge="
				+ zahlungseingaenge + ", auftrag=" + auftrag + "]";
	}

}
