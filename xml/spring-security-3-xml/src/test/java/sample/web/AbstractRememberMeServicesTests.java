package sample.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AbstractRememberMeServicesTests {
	final String key = "key";

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	PersistentTokenRepository tokenRepository;

	@Autowired
	PersistentTokenBasedRememberMeServices service;

	@Autowired
	List<RememberMeServices> services;

	@Test
	public void configLoads() {
	}

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