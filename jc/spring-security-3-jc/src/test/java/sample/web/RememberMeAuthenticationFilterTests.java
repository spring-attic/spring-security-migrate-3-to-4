package sample.web;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RememberMeAuthenticationFilterTests {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	RememberMeServices rememberMeServices;

	@Autowired
	RememberMeAuthenticationFilter filter;

	@Test
	public void configLoads() {}

	@Configuration
	static class Config {

		@Bean
		public RememberMeAuthenticationFilter rememberMeAuthenticationFilter(AuthenticationManager authenticationManager, RememberMeServices rememberMeServices) {
			RememberMeAuthenticationFilter filter = new RememberMeAuthenticationFilter(authenticationManager,rememberMeServices);
			return filter;
		}

		@Bean
		public AuthenticationManager authenticationManager() {
			AuthenticationManager manager = mock(AuthenticationManager.class);
			return manager;
		}

		@Bean
		public RememberMeServices rememberMeServices() {
			RememberMeServices services = mock(RememberMeServices.class);
			return services;
		}
	}
}