package sample.core;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserDetailsServiceWrapperTests {

	@Autowired
	AuthenticationManager auth;

	@Test
	public void hasHierarchy() {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("admin", "password");

		Authentication authenticate = auth.authenticate(token);

		assertThat(authenticate.getAuthorities()).onProperty("authority").containsOnly("ROLE_USER","ROLE_ADMIN");
	}
}