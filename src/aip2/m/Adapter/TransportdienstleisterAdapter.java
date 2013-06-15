package aip2.m.Adapter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import aip2.m.InterfacesExtern.ILieferungModulExtern;

public class TransportdienstleisterAdapter {
	private final static int port = 8080;
	
	private final ILieferungModulExtern lieferungModulExtern;
	
	public TransportdienstleisterAdapter(ILieferungModulExtern lieferungModulExtern) {
		this.lieferungModulExtern = lieferungModulExtern;
	}
	
	public String sendeTransportAuftrag(int lieferungsId, String adresse) {
		Client client = Client.create();
		WebResource service = client.resource("http://localhost:"+port+"/transport");
		return service.path("create").queryParam("id", ""+lieferungsId).queryParam("adr", adresse).put(String.class);
	}
	
	@Deprecated
	public void jedeNacht() {
		lieferungModulExtern.bestaetigeLieferung(1);
	}
}
