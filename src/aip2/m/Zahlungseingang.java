package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "zahlungseingang")
public class Zahlungseingang {

	private int nr;
	private Rechnung rechnung;

	public Zahlungseingang() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zahlungseingang_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	@OneToOne(mappedBy = "zahlungseingang")
	public Rechnung Rechnung() {
		return rechnung;
	}
	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}

}
