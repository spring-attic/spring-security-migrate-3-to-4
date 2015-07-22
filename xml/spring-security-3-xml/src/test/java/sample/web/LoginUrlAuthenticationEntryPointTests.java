package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LoginUrlAuthenticationEntryPointTests {
	@Test
	public void configLoads() {
	}

	@Test
	public void deprecatedProperties() {
		LoginUrlAuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint("/login");
	}
}