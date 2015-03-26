package sample.core;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SwitchUserFilterTests {

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Autowired
	SwitchUserFilter filter;

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();
	}

	@After
	public void cleanup() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void switchUserUrl() throws Exception {
		request.setRequestURI("/j_spring_security_switch_user");

		filter.doFilter(request, response, chain);

		assertThat(response.getStatus()).isEqualTo(
				HttpServletResponse.SC_UNAUTHORIZED);
	}

	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void exitUserUrl() throws Exception {
		request.setRequestURI("/j_spring_security_exit_user");

		filter.doFilter(request, response, chain);
	}

	@Configuration
	static class Config {
		@Bean
		public SwitchUserFilter switchUserFilter(
				UserDetailsService userDetailsService) {
			SwitchUserFilter filter = new SwitchUserFilter();
			filter.setExitUserUrl("/j_spring_security_exit_user");
			filter.setSwitchUserUrl("/j_spring_security_switch_user");
			filter.setTargetUrl("/");
			filter.setUserDetailsService(userDetailsService);
			return filter;
		}

		@Bean
		public UserDetailsService userDetails() {
			UserDetailsService uds = mock(UserDetailsService.class);
			when(uds.loadUserByUsername(anyString())).thenThrow(new UsernameNotFoundException("not found"));
			return uds;
		}
	}
}