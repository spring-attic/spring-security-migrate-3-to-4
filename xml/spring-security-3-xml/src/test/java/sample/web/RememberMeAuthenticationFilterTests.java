package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RememberMeAuthenticationFilterTests {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	RememberMeServices rememberMeServices;

	@Autowired
	RememberMeAuthenticationFilter filter;

	@Test
	public void configLoads() {}

	@Test
	public void deprecated() {
		RememberMeAuthenticationFilter filter =
				new RememberMeAuthenticationFilter(authenticationManager,rememberMeServices);
	}
}