package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "lieferung")
public class Lieferung implements ILieferung {

	private int nr;
	private ITransportauftrag transportauftrag;
	private IAuftrag auftrag;

	public Lieferung() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferung#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lieferung_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferung#getAuftrag()
	 */
	@Override
	@OneToOne(mappedBy = "lieferung")
	public IAuftrag getAuftrag() {
		return auftrag;
	}
	public void setAuftrag(IAuftrag auftrag) {
		this.auftrag = auftrag;
	}

	/* (non-Javadoc)
	 * @see aip2.m.ILieferung#getTransportauftrag()
	 */
	@Override
	@OneToOne(mappedBy = "lieferung")
	public ITransportauftrag getTransportauftrag() {
		return transportauftrag;
	}
	public void setTransportauftrag(ITransportauftrag transportauftrag) {
		this.transportauftrag = transportauftrag;
	}

}
