package sample.role_;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RolePrefixTests {
	@Autowired
	FilterChainProxy springSecurityFilterChain;
	@Autowired
	MessageService messageService;

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;

	@Before
	public void setup() {
		setup("USER");

		request = new MockHttpServletRequest();
		request.setMethod("GET");
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();
	}

	@After
	public void cleanup() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void doFilter() throws Exception {
		SecurityContext context = SecurityContextHolder.getContext();
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

		springSecurityFilterChain.doFilter(request, response, chain);

		assertThat(response.getStatus()).isEqualTo(HttpServletResponse.SC_OK);
	}

	@Test
	public void doFilterDenied() throws Exception {
		setup("DENIED");

		SecurityContext context = SecurityContextHolder.getContext();
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

		springSecurityFilterChain.doFilter(request, response, chain);

		assertThat(response.getStatus()).isEqualTo(HttpServletResponse.SC_FORBIDDEN);
	}

	@Test
	public void message() {
		messageService.getMessage();
	}

	@Test
	public void jsrMessage() {
		messageService.getJsrMessage();
	}

	@Test(expected = AccessDeniedException.class)
	public void messageDenied() {
		setup("DENIED");

		messageService.getMessage();
	}

	@Test(expected = AccessDeniedException.class)
	public void jsrMessageDenied() {
		setup("DENIED");

		messageService.getJsrMessage();
	}

	// SEC-2926
	@Test
	public void doFilterIsUserInRole() throws Exception {
		SecurityContext context = SecurityContextHolder.getContext();
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

		chain = new MockFilterChain() {

			@Override
			public void doFilter(ServletRequest request, ServletResponse response)
					throws IOException, ServletException {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				assertThat(httpRequest.isUserInRole("USER")).isTrue();
				assertThat(httpRequest.isUserInRole("INVALID")).isFalse();
				super.doFilter(request, response);
			}

		};

		springSecurityFilterChain.doFilter(request, response, chain);

		assertThat(chain.getRequest()).isNotNull();
	}

	private void setup(String role) {
		TestingAuthenticationToken user = new TestingAuthenticationToken("user", "password", role);
		SecurityContextHolder.getContext().setAuthentication(user);
	}

	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled=true, jsr250Enabled=true)
	static class Config extends WebSecurityConfigurerAdapter {

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth
				.inMemoryAuthentication()
					.withUser("user").password("password").roles("USER");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.anyRequest().hasAuthority("USER");
		}

		@Bean
		public MessageService messageService() {
			return new HelloWorldMessageService();
		}

		@Bean
		public static DefaultRolesPrefixPostProcessor defaultRolesPrefixPostProcessor() {
			return new DefaultRolesPrefixPostProcessor();
		}
	}
}
