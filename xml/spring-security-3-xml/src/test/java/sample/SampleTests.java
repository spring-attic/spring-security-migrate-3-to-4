package sample;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/security.xml",
"file:src/main/webapp/WEB-INF/spring/mvc/servlet-context.xml"})
@WebAppConfiguration
public class SampleTests {
	@Autowired
	WebApplicationContext context;
	@Autowired
	FilterChainProxy springSecurityFilter;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.addFilters(springSecurityFilter)
				.build();
	}

	@Test
	public void loginAllowAnonymous() throws Exception {
		mockMvc.perform(get("/login"))
			.andExpect(status().isOk());
	}

	@Test
	public void secureRequiresAuthentication() throws Exception {
		MvcResult result = mockMvc
				.perform(get("/secure"))
				.andReturn();

		assertThat(result.getResponse().getRedirectedUrl()).endsWith("/login");
	}

	@Test
	public void noSecurityHeaders() throws Exception {
		MvcResult result = mockMvc.perform(get("/login")).andReturn();

		assertThat(result.getResponse().getHeaderNames()).isEmpty();
	}

	@Test
	public void csrfDisabled() throws Exception {
		MvcResult result = mockMvc.perform(post("/something"))
				.andReturn();

		assertThat(result.getResponse().getStatus()).isNotEqualTo(HttpServletResponse.SC_FORBIDDEN);
	}

	@Test
	public void logout() throws Exception {
		MockHttpSession session = new MockHttpSession();
		MvcResult result = mockMvc.perform(get("/j_spring_security_logout").session(session))
				.andReturn();

		assertThat(result.getRequest().getSession().getId()).isNotEqualTo(session.getId());
	}
}