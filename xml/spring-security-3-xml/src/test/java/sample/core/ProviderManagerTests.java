package sample.core;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProviderManagerTests {

	@Autowired
	List<AuthenticationProvider> providers;

	@Qualifier("parent")
	@Autowired
	ProviderManager parent;

	@Test
	public void contextLoads() {
	}

	@Test
	public void javaCompiles() {
		ProviderManager provider = new ProviderManager(providers, parent);
	}
}
