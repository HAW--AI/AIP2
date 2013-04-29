package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "auftrag")
public class Auftrag {

	private int nr;
	private boolean abgeschlossen;
	private long beauftragtAm;
	private Lieferung lieferung;
	private Rechnung rechnung;
	private Angebot angebot;

	public Auftrag() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auftrag_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public boolean isAbgeschlossen() {
		return abgeschlossen;
	}

	public void setAbgeschlossen(boolean abgeschlossen) {
		this.abgeschlossen = abgeschlossen;
	}

	public long getBeauftragtAm() {
		return beauftragtAm;
	}

	public void setBeauftragtAm(long beauftragtAm) {
		this.beauftragtAm = beauftragtAm;
	}

	@OneToOne(mappedBy = "auftrag")
	public Lieferung getLieferung() {
		return lieferung;
	}

	public void setLieferung(Lieferung lieferung) {
		this.lieferung = lieferung;
	}

	@OneToOne(mappedBy = "auftrag")
	public Rechnung getRechnung() {
		return rechnung;
	}

	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}

	@OneToOne(mappedBy = "auftrag")
	public Angebot getAngebot() {
		return angebot;
	}

	public void setAngebot(Angebot angebot) {
		this.angebot = angebot;
	}

}
