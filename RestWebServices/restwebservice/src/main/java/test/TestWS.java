package test;

import java.net.URI;
import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import rest.authenticate.filter.AuthenticateFilter;



public class TestWS {

	private static final String webServiceURI = "http://localhost:8080/restwebservice";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		
		String pass =Base64.getEncoder().encodeToString(("admin"+":"+"admin").getBytes());
		
		// response
		System.out.println(webTarget.path("rest").path("helloworld").request()
				.header(AuthenticateFilter.AUTHENTICATION_HEADER, pass).accept(MediaType.TEXT_PLAIN).get(Response.class).toString());

		// text
		System.out.println(webTarget.path("rest").path("helloworld").request()
				.header(AuthenticateFilter.AUTHENTICATION_HEADER, pass).accept(MediaType.TEXT_PLAIN).get(String.class));

		// xml
		System.out.println(webTarget.path("rest").path("helloworld").request()
				.header(AuthenticateFilter.AUTHENTICATION_HEADER, pass).accept(MediaType.TEXT_XML).get(String.class));

		// html
		System.out.println(webTarget.path("rest").path("helloworld").request()
				.header(AuthenticateFilter.AUTHENTICATION_HEADER, pass).accept(MediaType.TEXT_HTML).get(String.class));
	}
}