package sample.cas;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CasAuthenticationFilterDefaultUrlsTests {

	@Mock
	AuthenticationManager authenticationManager;

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();

		when(authenticationManager.authenticate(any(Authentication.class))).thenThrow(new UsernameNotFoundException(""));
	}

	@Test
	public void filterProcessUrl() throws Exception {
		request.setServletPath("/j_spring_cas_security_check");

		CasAuthenticationFilter filter = new CasAuthenticationFilter();
		filter.setFilterProcessesUrl("/j_spring_cas_security_check");
		filter.setAuthenticationManager(authenticationManager);
		filter.afterPropertiesSet();

		filter.doFilter(request, response, chain);

		assertThat(response.getStatus()).isEqualTo(
				HttpServletResponse.SC_UNAUTHORIZED);
	}
}