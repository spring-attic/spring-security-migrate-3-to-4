package sample.core;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class InMemoryDaoImplTests {

	@Autowired
	UserDetailsService uds;

	@Test
	public void findUser() {
		uds.loadUserByUsername("user");
	}

	@Test
	public void javaExample() {
		Properties properties = new Properties();
		properties.put("user","password,ROLE_USER");

		InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager(properties);
	}
}