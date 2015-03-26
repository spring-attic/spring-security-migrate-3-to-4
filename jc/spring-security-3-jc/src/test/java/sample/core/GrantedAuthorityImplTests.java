package sample.core;

import org.junit.Test;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

public class GrantedAuthorityImplTests {

	@Test
	public void constructor() {
		new GrantedAuthorityImpl("ROLE_USER");
	}
}