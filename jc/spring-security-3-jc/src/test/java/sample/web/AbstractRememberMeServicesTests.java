package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@RunWith(MockitoJUnitRunner.class)
public class AbstractRememberMeServicesTests {
	final String key = "key";

	@Mock
	UserDetailsService userDetailsService;

	@Mock
	PersistentTokenRepository tokenRepository;


	@Test
	public void deprecatedPropertiesPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices services = new PersistentTokenBasedRememberMeServices(
				key, userDetailsService, tokenRepository);
	}

	@Test
	public void deprecatedPropertiesTokenBasedRememberMeServices() {
		TokenBasedRememberMeServices services = new TokenBasedRememberMeServices(
				key, userDetailsService);
	}
}