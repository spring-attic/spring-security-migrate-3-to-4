package sample.web;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@RunWith(MockitoJUnitRunner.class)
public class FilterChainProxyTests {

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Mock
	Filter mockFilter;

	FilterChainProxy securityFilterChain;

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();

		Map<RequestMatcher,List<Filter>> filterChainMap = new HashMap<RequestMatcher, List<Filter>>();
		filterChainMap.put(AnyRequestMatcher.INSTANCE, Arrays.asList(mockFilter));

		securityFilterChain = new FilterChainProxy();
		securityFilterChain.setFilterChainMap(filterChainMap);
	}

	@After
	public void cleanup() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void httpPathType() throws Exception {
		securityFilterChain.doFilter(request, response, chain);

		verify(mockFilter).doFilter(any(HttpServletRequest.class),
				any(HttpServletResponse.class), any(FilterChain.class));
	}
}