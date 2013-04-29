package aip2.m;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "angebot")
public class Angebot implements IAngebot {

	private int nr;
	private long gueltigAb;
	private long gueltigBis;
	private int gesamtpreis;
	private IAuftrag auftrag;
	private IKunde kunde;
	private HashSet<Produkt> produkte;

	public Angebot() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getNr()
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "angebot_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getGueltigAb()
	 */
	@Override
	public long getGueltigAb() {
		return gueltigAb;
	}

	public void setGueltigAb(long gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getGueltigBis()
	 */
	@Override
	public long getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(long gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getGesamtpreis()
	 */
	@Override
	public int getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(int gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getAuftrag()
	 */
	@Override
	@OneToOne(mappedBy = "angebot")
	public IAuftrag getAuftrag() {
		return auftrag;
	}

	public void setAuftrag(IAuftrag auftrag) {
		this.auftrag = auftrag;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getKunde()
	 */
	@Override
	@ManyToOne(/*mappedBy = "angebote"*/)
	public IKunde getKunde() {
		return kunde;
	}

	public void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IAngebot#getProdukte()
	 */
	@Override
	@ManyToMany(mappedBy = "angebot")
	public HashSet<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(HashSet<Produkt> produkte) {
		this.produkte = produkte;
	}

}
