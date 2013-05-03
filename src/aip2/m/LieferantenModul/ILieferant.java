package aip2.m.LieferantenModul;

import java.util.Set;

import aip2.m.BestellungsModul.IBestellung;

public interface ILieferant {

	int getLieferantenNr();

	String getName();

	String getAdresse();

	String getKontoverbindung();

	Set<IEinkaufsinfosatz> getEinkaufsinfosaetze();

	Set<IOrderbuchsatz> getOrderbuchsaetze();

	Set<IBestellung> getBestellungen();

}