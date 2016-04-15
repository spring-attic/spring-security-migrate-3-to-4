package sample.core;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class AuthenticationDetailsSourceImplTests {

	@Test
	public void test() {
		CustomWebAuthenticationDetailsSource source = new CustomWebAuthenticationDetailsSource();
	}

	public class CustomWebAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

		public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
			return new CustomWebAuthenticationDetails(context);
		}
	}
}
