package sample.core;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@RunWith(MockitoJUnitRunner.class)
public class InMemoryDaoImplTests {

	@Mock
	UserDetailsService uds;

	@Test
	public void javaExample() {
		Properties properties = new Properties();
		properties.put("user", "password,ROLE_USER");

		InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager(properties);
	}
}