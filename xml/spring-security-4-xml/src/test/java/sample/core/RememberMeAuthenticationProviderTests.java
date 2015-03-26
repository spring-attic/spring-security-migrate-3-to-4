package sample.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RememberMeAuthenticationProviderTests {
	final String key = "key";

	@Autowired
	RememberMeAuthenticationProvider provider;

	@Test
	public void contextLoads() {}

	@Test
	public void javaCompiles() {
		RememberMeAuthenticationProvider provider = new RememberMeAuthenticationProvider(key);
	}
}
