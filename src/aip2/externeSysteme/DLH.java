package aip2.externeSysteme;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class DLH {	
	public static void main(String[] args) {
		URI uri = UriBuilder.fromUri("http://localhost/").port(8080).build();
    	HttpServer server = null;
		try {
			server = HttpServerFactory.create(uri);
		} catch (IllegalArgumentException | IOException e) {
			System.err.println("Server is broken :(");
			System.exit(0);
		}
    	server.start();    	
    	System.out.println("Server is running...");
	}
}
