package aip2.externeSysteme;

import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DLHPacket {
	private String lieferNummer = "";
	private String adresse = "";
	private long auftragZeit = -1L;
	private String trackingCode = "";
	private boolean geliefert = false;
	
	DLHPacket() {		
	}
	
	DLHPacket(String lieferNummer, String adresse) {
		this.lieferNummer = lieferNummer;
		this.adresse = adresse;
		this.auftragZeit = System.currentTimeMillis();
		this.trackingCode = UUID.randomUUID().toString();
	}

	@XmlElement( name = "lieferNummer" )
	public String getLieferNummer() {
		return lieferNummer;
	}
	
	@XmlElement( name = "geliefert" )
	public boolean isGeliefert() {
		return geliefert;
	}

	public void setGeliefert(boolean geliefert) {
		this.geliefert = geliefert;
	}

	@XmlElement( name = "adresse" )
	public String getAdresse() {
		return adresse;
	}

	@XmlElement( name = "auftragsZeit" )
	public long getAuftragZeit() {
		return auftragZeit;
	}

	@XmlElement( name = "trackingCode" )
	public String getTrackingCode() {
		return trackingCode;
	}

	@Override
	public String toString() {
		return "DLHPacket [lieferNummer=" + lieferNummer + ", adresse="
				+ adresse + ", auftragZeit=" + auftragZeit + ", trackingCode="
				+ trackingCode + ", geliefert=" + geliefert + "]";
	}
}
