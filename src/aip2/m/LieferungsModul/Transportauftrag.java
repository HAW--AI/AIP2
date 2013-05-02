package aip2.m.LieferungsModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.Interfaces.ILieferung;
import aip2.m.Interfaces.ITransportauftrag;

@Entity
@Table(name = "transportauftrag")
public class Transportauftrag implements ITransportauftrag {

	private int nr;
	private ILieferung lieferung;

	public Transportauftrag() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.ITransportauftrag#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transportauftrag_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ITransportauftrag#getLieferung()
	 */
	@Override
	@OneToOne(mappedBy = "transportauftrag")
	public ILieferung getLieferung() {
		return lieferung;
	}
	public void setLieferung(ILieferung lieferung) {
		this.lieferung = lieferung;
	}

}
