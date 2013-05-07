package aip2.m.AngebotAuftragModul;

final class AngebotAuftragModulLogik {
	@SuppressWarnings("unused")
	private final AngebotVerwalter angebotVerwalter;
	@SuppressWarnings("unused")
	private final AuftragVerwalter auftragVerwalter;

	AngebotAuftragModulLogik(AngebotVerwalter angebotVerwalter,
			AuftragVerwalter auftragVerwalter) {
		this.angebotVerwalter = angebotVerwalter;
		this.auftragVerwalter = auftragVerwalter;
	}

}
