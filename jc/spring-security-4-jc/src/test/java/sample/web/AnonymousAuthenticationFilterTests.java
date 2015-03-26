package sample.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

public class AnonymousAuthenticationFilterTests {
	final String key = "key";
	UserAttribute attrs;

	@Before
	public void setup() {
		attrs = new UserAttribute();
		attrs.setPassword("anonymous");
		attrs.setAuthorities(AuthorityUtils
				.createAuthorityList("ROLE_ANONYMOUS"));
	}

	@Test
	public void deprecatedProperties() {
		AnonymousAuthenticationFilter filter =
				new AnonymousAuthenticationFilter(key,attrs.getPassword(),attrs.getAuthorities());
	}
}