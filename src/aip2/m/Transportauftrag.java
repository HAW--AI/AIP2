package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "transportauftrag")
public class Transportauftrag {

	private int nr;
	private Lieferung lieferung;

	public Transportauftrag() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transportauftrag_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	@OneToOne(mappedBy = "transportauftrag")
	public Lieferung Lieferung() {
		return lieferung;
	}
	public void setLieferung(Lieferung lieferung) {
		this.lieferung = lieferung;
	}

}
