package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BasicAuthenticationFilterTests {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AuthenticationEntryPoint entryPoint;

	final boolean ignoreFailure = false;

	@Test
	public void configLoads() {}

	@Test
	public void deprecated() {
		BasicAuthenticationFilter filter =
				new BasicAuthenticationFilter(authenticationManager,entryPoint);
	}
}
