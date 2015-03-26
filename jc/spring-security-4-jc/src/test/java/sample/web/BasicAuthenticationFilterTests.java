package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RunWith(MockitoJUnitRunner.class)
public class BasicAuthenticationFilterTests {
	@Mock
	AuthenticationManager authenticationManager;

	@Mock
	AuthenticationEntryPoint entryPoint;

	final boolean ignoreFailure = false;


	@Test
	public void deprecated() {
		BasicAuthenticationFilter filter =
				new BasicAuthenticationFilter(authenticationManager,entryPoint);
	}
}
