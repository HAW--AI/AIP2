package aip2.m.AngebotAuftragModul;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aip2.m.InterfacesExtern.IAngebotAuftragModulExtern;
import aip2.m.KundenModul.IKunde;
import aip2.m.KundenModul.IKundeIntern;
import aip2.m.KundenModul.KundenTyp;
import aip2.m.LieferungsModul.ILieferungModulIntern;
import aip2.m.ProduktModul.IProdukt;
import aip2.m.ProduktModul.IProduktIntern;
import aip2.m.ProduktModul.ProduktTyp;
import aip2.m.TransaktionModul.ITransaktionIntern;

public final class AngebotAuftragModulFassade implements
		IAngebotAuftragModulExtern {

	private final ITransaktionIntern transaktion;
	private final AngebotAuftragModulLogik angebotAuftragModulLogik;
	@SuppressWarnings("unused")
	private final AngebotVerwalter angebotVerwalter;
	@SuppressWarnings("unused")
	private final AuftragVerwalter auftragVerwalter;

	private final IProduktIntern iProduktIntern;
	@SuppressWarnings("unused")
	private final ILieferungModulIntern iLieferungModulIntern;
	private final IKundeIntern iKundeIntern;

	AngebotAuftragModulFassade(ITransaktionIntern transaktion,
			AngebotAuftragModulLogik angebotAuftragModulLogik,
			AngebotVerwalter angebotVerwalter,
			AuftragVerwalter auftragVerwalter, IProduktIntern iProduktIntern,
			ILieferungModulIntern iLieferungModulIntern, IKundeIntern iKundeIntern) {
		this.transaktion = transaktion;
		this.angebotAuftragModulLogik = angebotAuftragModulLogik;
		this.angebotVerwalter = angebotVerwalter;
		this.auftragVerwalter = auftragVerwalter;
		this.iProduktIntern = iProduktIntern;
		this.iLieferungModulIntern = iLieferungModulIntern;
		this.iKundeIntern = iKundeIntern;
	}

	@Override
	public AngebotTyp erstelleAngebot(KundenTyp kundenTyp, Date angebotsEnde,
			Map<ProduktTyp, Integer> anzahlProdukte, int preisCent) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			Map<IProdukt, Integer> iproduktMap = new HashMap<>();
			for (ProduktTyp produktTyp : anzahlProdukte.keySet()) {
				IProdukt produkt = iProduktIntern.getIProdukt(produktTyp
						.getNr());
				iproduktMap.put(produkt, anzahlProdukte.get(produktTyp));
			}
			IKunde kunde = iKundeIntern.getKunde(kundenTyp.getKundenNr());

			AngebotTyp angebot = angebotAuftragModulLogik.erstelleAngebot(
					kunde, angebotsEnde, iproduktMap, preisCent);

			if (myTransaction)
				transaktion.commitTransaction();

			return angebot;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return null;
		}
	}

	@Override
	public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			AuftragTyp auftrag = angebotAuftragModulLogik
					.erstelleAuftrag(angebot);

			if (myTransaction)
				transaktion.commitTransaction();

			return auftrag;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return null;
		}
	}

	@Override
	public List<AngebotTyp> sucheAngebote(KundenTyp kunde) {
		return angebotAuftragModulLogik.sucheAngebote(kunde);
	}

	@Override
	public List<AuftragTyp> sucheAuftraege(int RechnungsNr) {
		return angebotAuftragModulLogik.sucheAuftraege(RechnungsNr);
	}

	@Override
	public boolean schliesseAbAuftrag(AuftragTyp auftrag) {
		try {
			boolean myTransaction = transaktion.checkStartMyTransaction();

			angebotAuftragModulLogik.schliesseAbAuftrag(auftrag);

			if (myTransaction)
				transaktion.commitTransaction();

			return true;
		} catch (Exception e) {
			transaktion.rollbackTransaction();
			return false;
		}
	}

}
