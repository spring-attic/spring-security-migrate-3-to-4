package sample.openid;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class OpenIDTests {

	@Autowired
	FilterChainProxy springSecurityFilter;

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		request.setMethod("GET");
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();
	}

	@Test
	public void filterProcessUrl() throws Exception {
		request.setServletPath("/j_spring_openid_security_check");

		springSecurityFilter.doFilter(request, response, chain);

		assertThat(response.getRedirectedUrl()).isNotNull();
	}
}
