package sample.config;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FilterChainMapPathTypeTests {

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Autowired
	@Qualifier("mockFilter")
	Filter mockFilter;
	@Autowired
	FilterChainProxy securityFilterChain;

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
	public void filterChainMap() throws Exception {
		securityFilterChain.doFilter(request,response,chain);

		verify(mockFilter).doFilter(any(HttpServletRequest.class), any(HttpServletResponse.class), any(FilterChain.class));
	}

	@Test
	public void get() {
		List<SecurityFilterChain> mappings = securityFilterChain.getFilterChains();
		for(SecurityFilterChain entry : mappings) {
			boolean matches = entry.matches(request);
			List<Filter> filters = entry.getFilters();
		}
	}
}