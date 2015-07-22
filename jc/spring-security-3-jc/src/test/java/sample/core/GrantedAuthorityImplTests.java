package sample.core;

import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class GrantedAuthorityImplTests {

	@Test
	public void constructor() {
		new SimpleGrantedAuthority("ROLE_USER");
	}
}