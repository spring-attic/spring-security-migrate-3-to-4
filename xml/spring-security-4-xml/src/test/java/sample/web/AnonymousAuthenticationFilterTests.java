package sample.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AnonymousAuthenticationFilterTests {
	final String key = "key";
	UserAttribute attrs;

	@Autowired
	AnonymousAuthenticationFilter filter;

	@Before
	public void setup() {
		attrs = new UserAttribute();
		attrs.setPassword("anonymous");
		attrs.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
	}

	@After
	public void cleanup() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void configLoads() {}

	@Test
	public void deprecatedProperties() {
		AnonymousAuthenticationFilter filter =
				new AnonymousAuthenticationFilter(key,attrs.getPassword(),attrs.getAuthorities());
	}
}