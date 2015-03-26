package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@RunWith(MockitoJUnitRunner.class)
public class ConcurrentSessionControlStrategyTests {

	@Mock
	SessionRegistry sessionRegistry;
	@Mock
	SessionAuthenticationStrategy sas;

	@Test
	public void deprecated() {
		ConcurrentSessionControlStrategy strategy = new ConcurrentSessionControlStrategy(
				sessionRegistry);
	}

}