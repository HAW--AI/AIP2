package aip2.m.KundenModul;

import java.util.Set;
import aip2.m.AngebotAuftragModul.IAngebot;

public interface IKunde {

	int getNr();

	String getName();

	String getAdresse();

	Set<IAngebot> getAngebote();
	
	boolean addAngebot(IAngebot angebot);

}