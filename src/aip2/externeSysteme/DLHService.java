package aip2.externeSysteme;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(value = "/transport")
public class DLHService {	
	private static Map<String, DLHPacket> packets = new HashMap<String, DLHPacket>();
	
	@PUT
	@Path(value = "/create")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)	
	public String putMessage(@QueryParam("id") String id, @QueryParam("adr") String adr) {
		System.out.println("Recv PUT: "+id+" / "+adr);
		
		DLHPacket p = new DLHPacket(id, adr);
		packets.put(p.getTrackingCode(), p);
		return p.getTrackingCode();
	}
	
	@GET
	@Path(value = "/info/{tracking}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_XML)	
	public DLHPacket getMessage(@PathParam("tracking") String id) {
		System.out.println("Recv GET: "+id+" ["+packets.containsKey(id.trim())+"]");
		
		if (!packets.containsKey(id.trim())) return new DLHPacket();
		return packets.get(id.trim());
	}
}