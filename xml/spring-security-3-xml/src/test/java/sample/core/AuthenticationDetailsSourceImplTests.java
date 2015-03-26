package sample.core;

import org.junit.Test;
import org.springframework.security.authentication.AuthenticationDetailsSourceImpl;

public class AuthenticationDetailsSourceImplTests {

	@Test
	public void test() {
		AuthenticationDetailsSourceImpl source = new AuthenticationDetailsSourceImpl();
		source.setClazz(CustomWebAuthenticationDetails.class);
	}

}
