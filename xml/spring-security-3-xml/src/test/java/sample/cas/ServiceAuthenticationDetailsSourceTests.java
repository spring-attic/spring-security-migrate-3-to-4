package sample.cas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ServiceAuthenticationDetailsSourceTests {
	final String artifactId = "TICKET";

	ServiceProperties serviceProperties;

	@Before
	public void setup() {
		serviceProperties = new ServiceProperties();
	}

	@Test
	public void xmlConfigurationLoads() {}

	@Test
	public void constructor() {
		new ServiceAuthenticationDetailsSource(serviceProperties);
	}

	@Test
	public void constructorString() {
		new ServiceAuthenticationDetailsSource(serviceProperties, artifactId);
	}
}
