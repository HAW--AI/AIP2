package aip2.m.Adapter;

import java.rmi.RemoteException;
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
			try {
				lieferungModulExtern.bestaetigeLieferung(l);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		DLH.abgelieferteLieferungenAbgeholt();
	}
}
