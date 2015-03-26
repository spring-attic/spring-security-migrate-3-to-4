package sample.cas;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;

public class ServiceAuthenticationDetailsSourceTests {
	final String artifactId = "TICKET";

	ServiceProperties serviceProperties;

	@Before
	public void setup() {
		serviceProperties = new ServiceProperties();
	}

	@Test
	public void constructor() {
		new ServiceAuthenticationDetailsSource(serviceProperties);
	}

	@Test
	public void constructorString() {
		new ServiceAuthenticationDetailsSource(serviceProperties, artifactId);
	}
}
