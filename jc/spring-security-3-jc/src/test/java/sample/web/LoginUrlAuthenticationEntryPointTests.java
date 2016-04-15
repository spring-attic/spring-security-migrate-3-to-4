package sample.web;

import org.junit.Test;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;



public class LoginUrlAuthenticationEntryPointTests {

	@Test
	public void deprecatedProperties() {
		LoginUrlAuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint("/login");
	}
}