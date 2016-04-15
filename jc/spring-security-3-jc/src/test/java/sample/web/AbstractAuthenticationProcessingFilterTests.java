package sample.web;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

public class AbstractAuthenticationProcessingFilterTests {
	static final String KEY = "KEY";

	OverridesAbstractAuthenticationProcessingFilter filter;

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();

		filter = new OverridesAbstractAuthenticationProcessingFilter();
	}

	@Test
	public void successfulAuthentication() throws Exception {
		filter.doFilter(request, response, chain);

		assertThat(request.getAttribute(KEY)).isNotNull();
	}

	static class OverridesAbstractAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

		protected OverridesAbstractAuthenticationProcessingFilter() {
			super(AnyRequestMatcher.INSTANCE);
		}

		protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,
				Authentication authResult) throws IOException, ServletException {

			request.setAttribute(KEY, authResult);
		}

		@Override
		public Authentication attemptAuthentication(HttpServletRequest request,
				HttpServletResponse response) throws AuthenticationException,
				IOException, ServletException {
			return new TestingAuthenticationToken("test", "notused", "ROLE_USER");
		}

	}

}