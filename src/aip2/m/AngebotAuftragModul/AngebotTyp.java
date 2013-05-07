package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.Map;

import aip2.m.KundenModul.IKunde;
import aip2.m.ProduktModul.IProdukt;

public final class AngebotTyp {
	private int nr;

	private Date gueltigAb;

	private Date gueltigBis;

	private int gesamtPreisCent;

	private IAuftrag auftrag;

	private IKunde kunde;

	//TODO IProdukt to ProduktTyp + in Verwalter
	private Map<IProdukt, Integer> produkte;

	AngebotTyp(int nr, Date gueltigAb, Date gueltigBis, int gesamtPreisCent,
			IAuftrag auftrag, IKunde kunde, Map<IProdukt, Integer> produkte) {
		this.nr = nr;
		this.gueltigAb = gueltigAb;
		this.gueltigBis = gueltigBis;
		this.gesamtPreisCent = gesamtPreisCent;
		this.auftrag = auftrag;
		this.kunde = kunde;
		this.produkte = produkte;
	}

	public int getNr() {
		return nr;
	}

	public Date getGueltigAb() {
		return gueltigAb;
	}

	public Date getGueltigBis() {
		return gueltigBis;
	}

	public int getGesamtPreisCent() {
		return gesamtPreisCent;
	}

	public IAuftrag getAuftrag() {
		return auftrag;
	}

	public IKunde getKunde() {
		return kunde;
	}

	public Map<IProdukt, Integer> getProdukte() {
		return produkte;
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
		AngebotTyp other = (AngebotTyp) obj;
		if (nr != other.nr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AngebotTyp [nr=" + nr + ", gueltigAb=" + gueltigAb
				+ ", gueltigBis=" + gueltigBis + ", gesamtPreisCent="
				+ gesamtPreisCent + ", auftrag=" + auftrag + ", kunde=" + kunde
				+ ", produkte=" + produkte + "]";
	}

}
