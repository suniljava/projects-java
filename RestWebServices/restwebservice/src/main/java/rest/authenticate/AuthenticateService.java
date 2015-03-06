package rest.authenticate;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

public class AuthenticateService {
	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		
		boolean authenticationStatus = "admin".equals(username.trim())
				&& "admin".equals(password.trim());
		System.out.println("authenticationStatus" + authenticationStatus);
		return authenticationStatus;
	}
}