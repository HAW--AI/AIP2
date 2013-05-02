package aip2.m.ProduktModul;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import aip2.m.AngebotAuftragModul.Angebot;
import aip2.m.BestellungsModul.Bestellung;
import aip2.m.Interfaces.IOrderbuch;
import aip2.m.Interfaces.IProdukt;
import aip2.m.LieferantenModul.Einkaufsinfosatz;
import aip2.m.WarenmeldungsModul.Warenausgangsmeldung;

@Entity
@Table(name = "produkt")
public class Produkt /*implements IProdukt*/ {

	private int nr;
	private String name;
	private int lagerbestand;
	private Set<Angebot> angebote;
//	private Set<Warenausgangsmeldung> warenausgangsmeldungen;
//	private Set<Bestellung> bestellungen;
//	private IOrderbuch orderbuch;
//	private Set<Einkaufsinfosatz> einkaufsinfosaetze;

	public Produkt() {
	}

	/* (non-Javadoc)
	 * @see aip2.m.IProdukt#getNr()
	 */
//	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produkt_nr")
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IProdukt#getName()
	 */
//	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IProdukt#getLagerbestand()
	 */
//	@Override
	public int getLagerbestand() {
		return lagerbestand;
	}

	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	/* (non-Javadoc)
	 * @see aip2.m.IProdukt#getAngebote()
	 */
//	@Override
	@ManyToMany//(mappedBy = "produkte")
	public Set<Angebot> getAngebote() {
		return angebote;
	}

	public void setAngebote(HashSet<Angebot> angebote) {
		this.angebote = angebote;
	}

//	/* (non-Javadoc)
//	 * @see aip2.m.IProdukt#getWarenausgangsmeldungen()
//	 */
//	@Override
//	@OneToMany(mappedBy = "produkt")
//	public Set<Warenausgangsmeldung> getWarenausgangsmeldungen() {
//		return warenausgangsmeldungen;
//	}
//
//	public void setWarenausgangsmeldungen(
//			HashSet<Warenausgangsmeldung> warenausgangsmeldungen) {
//		this.warenausgangsmeldungen = warenausgangsmeldungen;
//	}
//
//	/* (non-Javadoc)
//	 * @see aip2.m.IProdukt#getBestellungen()
//	 */
//	@Override
//	@OneToMany(mappedBy = "produkt")
//	public Set<Bestellung> getBestellungen() {
//		return bestellungen;
//	}
//
//	public void setBestellungen(HashSet<Bestellung> bestellungen) {
//		this.bestellungen = bestellungen;
//	}

//	/* (non-Javadoc)
//	 * @see aip2.m.IProdukt#getOrderbuch()
//	 */
//	@Override
//	@OneToOne(mappedBy = "produkt")
//	public IOrderbuch getOrderbuch() {
//		return orderbuch;
//	}
//
//	public void setOrderbuch(IOrderbuch orderbuch) {
//		this.orderbuch = orderbuch;
//	}
//
//	/* (non-Javadoc)
//	 * @see aip2.m.IProdukt#getEinkaufsinfosaetze()
//	 */
//	@Override
//	@OneToMany//(mappedBy = "produkt")
//	public Set<Einkaufsinfosatz> getEinkaufsinfosaetze() {
//		return einkaufsinfosaetze;
//	}
//
//	public void setEinkaufsinfosaetze(HashSet<Einkaufsinfosatz> einkaufsinfosaetze) {
//		this.einkaufsinfosaetze = einkaufsinfosaetze;
//	}
	
}
