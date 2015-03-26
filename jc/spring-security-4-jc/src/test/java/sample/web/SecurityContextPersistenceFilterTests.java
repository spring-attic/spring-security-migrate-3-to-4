package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SecurityContextPersistenceFilterTests {

	@Test
	public void configLoads() {}

	@Configuration
	static class Config {
		@Bean
		public SecurityContextPersistenceFilter securityContextPersistenceFilter(SecurityContextRepository securityContextRepository) {
			SecurityContextPersistenceFilter filter = new SecurityContextPersistenceFilter(securityContextRepository);
			return filter;
		}

		@Bean
		public SecurityContextRepository securityContextRepository() {
			return new NullSecurityContextRepository();
		}
	}
}