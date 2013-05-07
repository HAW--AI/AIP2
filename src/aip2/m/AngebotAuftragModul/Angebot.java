package aip2.m.AngebotAuftragModul;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.persistence.*;

import aip2.m.KundenModul.IKunde;
import aip2.m.KundenModul.Kunde;
import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.Produkt;

/**
 * Angebots Entität inklusive Speicherung in der DB
 * 
 */
@Entity
@Table(name = "Angebot")
public final class Angebot implements IAngebot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "angebot_nr")
	private int nr;

	@Temporal(TemporalType.TIME)
	private Date gueltigAb;

	@Temporal(TemporalType.TIME)
	private Date gueltigBis;

	private int gesamtPreisCent;

	@OneToOne(mappedBy = "angebot", targetEntity = Auftrag.class)
	private IAuftrag auftrag;

	@JoinColumn
	@ManyToOne(targetEntity = Kunde.class)
	private IKunde kunde;

	// @JoinColumn
	// @ManyToMany(targetEntity = Produkt.class)
	// private List<IProduktMenge> produkte;
	// @CollectionTable//(name = "ProduktMenge")//, joinColumns = @JoinColumn)
	// @MapKeyJoinColumn
	// //Lets get CRAZY!!!
	// @MapKeyType(@Type(parameters = {@Parameter(value =
	// "aip2.m.ProduktModul.Produkt", name = "")}, type = ""))
	// TODO teste wie DB die Map speichert?
	// @Transient
	@ElementCollection
	@MapKeyClass(Produkt.class)
	private Map<IProdukt, Integer> produkte;

	/**
	 * For Hibernate
	 */
	@SuppressWarnings("unused")
	private Angebot() {
	}

	Angebot(Date gueltigAb, Date gueltigBis, int gesamtPreisCent, IKunde kunde,
			Map<IProdukt, Integer> /* List<IProduktMenge> */produkte) {
		super();
		this.gueltigAb = gueltigAb;
		this.gueltigBis = gueltigBis;
		this.gesamtPreisCent = gesamtPreisCent;
		this.kunde = kunde;
		this.produkte = produkte;
	}

	@Override
	public int getAngebotsNr() {
		return nr;
	}

	@Override
	public Date getGueltigAb() {
		return gueltigAb;
	}

	void setGueltigAb(Date gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	@Override
	public Date getGueltigBis() {
		return gueltigBis;
	}

	void setGueltigBis(Date gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	@Override
	public int getGesamtpreis() {
		return gesamtPreisCent;
	}

	void setGesamtpreis(int gesamtPreisCent) {
		this.gesamtPreisCent = gesamtPreisCent;
	}

	@Override
	public IAuftrag getAuftrag() {
		return auftrag;
	}

	void setAuftrag(IAuftrag auftrag) {
		this.auftrag = auftrag;
	}

	@Override
	public IKunde getKunde() {
		return kunde;
	}

	void setKunde(IKunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public Map<IProdukt, Integer>/* List<IProduktMenge> */getProdukte() {
		return Collections.unmodifiableMap(produkte);
	}

	void setProdukte(Map<IProdukt, Integer>/* List<IProduktMenge> */produkte) {
		this.produkte = produkte;
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
		Angebot other = (Angebot) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Angebot [nr=" + nr + ", gesamtPreisCent=" + gesamtPreisCent
				+ ", auftrag=" + auftrag + ", kunde=" + kunde + ", produkte="
				+ produkte + ", getGueltigAbDatum()=" + gueltigAb
				+ ", getGueltigBisDatum()=" + gueltigBis + "]";
	}

}
