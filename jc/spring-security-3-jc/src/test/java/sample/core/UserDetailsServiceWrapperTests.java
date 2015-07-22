package sample.core;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyAuthoritiesMapper;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserDetailsServiceWrapperTests {

	@Autowired
	AuthenticationManager auth;

	@Test
	public void hasHierarchy() {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				"admin", "password");

		Authentication authenticate = auth.authenticate(token);

		assertThat(authenticate.getAuthorities()).onProperty("authority")
				.containsOnly("ROLE_USER", "ROLE_ADMIN");
	}

	@Configuration
	static class Config {
		@Bean
		public AuthenticationManager authenticationManager(List<AuthenticationProvider> providers) {
			return new ProviderManager(providers);
		}

		@Bean
		public UserDetailsService userDetailsService() {
			return new UserDetailsService() {
				@Override
				public UserDetails loadUserByUsername(String username)
						throws UsernameNotFoundException {
					return new User(username, "password", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
				}
			};
		}

		@Bean
		public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, GrantedAuthoritiesMapper authoritiesMapper) {
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(userDetailsService);
			provider.setAuthoritiesMapper(authoritiesMapper);
			return provider;
		}

		@Bean
		public RoleHierarchyAuthoritiesMapper roleHierarchyAuthoritiesMapper(RoleHierarchy roleHierarchy) {
			return new RoleHierarchyAuthoritiesMapper(roleHierarchy);
		}

		@Bean
		public RoleHierarchy roleHierarchy() {
			RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
			hierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
			return hierarchy;
		}
	}
}
