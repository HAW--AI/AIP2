package aip2.m.ProduktModul;

import java.util.Set;

import aip2.m.AngebotAuftragModul.IAngebot;
import aip2.m.BestellungsModul.IBestellung;
import aip2.m.LieferantenModul.IEinkaufsinfosatz;
import aip2.m.LieferantenModul.IOrderbuch;
import aip2.m.WarenmeldungsModul.IWarenausgangsmeldung;

public interface IProdukt {

	int getProduktNr();

	String getName();

	int getLagerbestand();

	Set<IAngebot> getAngebote();

	Set<IWarenausgangsmeldung> getWarenausgangsmeldungen();

	Set<IBestellung> getBestellungen();

	IOrderbuch getOrderbuch();

	Set<IEinkaufsinfosatz> getEinkaufsinfosaetze();

}