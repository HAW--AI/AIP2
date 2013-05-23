package aip2.m.Adapter;

import java.util.List;

import aip2.externeSysteme.DLH;
import aip2.m.InterfacesExtern.ILieferungModulExtern;

public class TransportdienstleisterAdapter {
	private final ILieferungModulExtern lieferungModulExtern;

	public TransportdienstleisterAdapter(
			ILieferungModulExtern lieferungModulExtern) {
		this.lieferungModulExtern = lieferungModulExtern;

	}

	public void jedeNacht() {
		List<Integer> lieferungen = DLH.getAbgelieferteLieferungen();

		for (int l : lieferungen) {
			lieferungModulExtern.bestaetigeLieferung(l);
		}

		DLH.abgelieferteLieferungenAbgeholt();
	}
}
