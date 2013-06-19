package aip2.m.Adapter;

import java.util.ArrayList;
import java.util.List;

import aip2.m.InterfacesExtern.ILieferungModulExtern;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TransportdienstleisterAdapter {
	private class Tuple<X, Y> {
		public final X x;
		public final Y y;

		public Tuple(X x, Y y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private final static int port = 8080;	
	private List<Tuple<Integer, String>> requests = new ArrayList<Tuple<Integer, String>>();
	private ILieferungModulExtern lieferungModulExtern;
	
	public TransportdienstleisterAdapter() {
	}
	
	public void setLieferungModulExtern(ILieferungModulExtern lieferungModulExtern) {
		this.lieferungModulExtern = lieferungModulExtern;
	}
	
	public String sendeTransportAuftrag(int lieferungsId, String adresse) {
		try{
			Client client = Client.create();
			WebResource service = client.resource("http://localhost:"+port+"/transport");
			String result = service.path("create").queryParam("id", ""+lieferungsId).queryParam("adr", adresse).put(String.class);
			
			// ok, no exceptions
			for (Tuple<Integer, String> t : requests) {
				String trackId = service.path("create").queryParam("id", ""+t.x).queryParam("adr", t.y).put(String.class);
				lieferungModulExtern.setTrackingCode(t.x, trackId);
			}
			
			return result;
		} catch(Exception e) {
			//DLH nicht da - cache request
			requests.add(new Tuple<Integer, String>(lieferungsId, adresse));
			return "~Unknown~";
		}
	}
	
//	@Deprecated
//	public void jedeNacht() {
//		lieferungModulExtern.bestaetigeLieferung(1);
//	}
}
