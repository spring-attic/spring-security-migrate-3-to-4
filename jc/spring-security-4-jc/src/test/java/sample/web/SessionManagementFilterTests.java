package sample.web;

import javax.servlet.Filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SessionManagementFilterTests {
	@Autowired
	SecurityContextRepository securityContextRepository;
	@Autowired
	SessionAuthenticationStrategy sessionAuthenticationStrategy;
	@Autowired
	Filter filter;

	@Test
	public void configLoads() {}

	@Configuration
	static class Config {
		@Bean
		public SessionManagementFilter sessionManagementFilter(SecurityContextRepository securityContextRepository, SessionAuthenticationStrategy sessionAuthenticationStrategy) {
			SessionManagementFilter filter = new SessionManagementFilter(securityContextRepository,sessionAuthenticationStrategy);
			return filter;
		}

		@Bean
		public SecurityContextRepository securityContextRepository() {
			return new NullSecurityContextRepository();
		}

		@Bean
		public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
			return new NullAuthenticatedSessionStrategy();
		}
	}
}