package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "lieferung")
public class Lieferung {

	private int nr;
	private Transportauftrag transportauftrag;
	private Auftrag auftrag;

	public Lieferung() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	@OneToOne(mappedBy = "lieferung")
	public Auftrag getAuftrag() {
		return auftrag;
	}
	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}

	@OneToOne(mappedBy = "lieferung")
	public Transportauftrag getTransportauftrag() {
		return transportauftrag;
	}
	public void setTransportauftrag(Transportauftrag transportauftrag) {
		this.transportauftrag = transportauftrag;
	}

}
