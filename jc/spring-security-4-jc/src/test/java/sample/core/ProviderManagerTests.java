package sample.core;

import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProviderManagerTests {
	@Autowired
	List<AuthenticationManager> managers;

	@Test
	public void configLoads() {}

	@Configuration
	static class Config {
		@Bean
		public AuthenticationManager authenticationManager(ProviderManager parent, List<AuthenticationProvider> providers) {
			return new ProviderManager(providers,parent);
		}

		@Bean
		public ProviderManager providerManager() {
			return mock(ProviderManager.class);
		}

		@Bean
		public AuthenticationProvider authenticationProvider() {
			return mock(AuthenticationProvider.class);
		}
	}
}
