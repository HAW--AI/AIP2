package aip2.m.AngebotAuftragModul;

import aip2.m.PersistenzModul.IPersistenzIntern;

final class AuftragVerwalter {
	@SuppressWarnings("unused")
	private final IPersistenzIntern persistenzManager;

	AuftragVerwalter(IPersistenzIntern pm) {
		this.persistenzManager = pm;
	}
}
