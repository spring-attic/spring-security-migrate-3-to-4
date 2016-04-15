package sample.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;

@RunWith(MockitoJUnitRunner.class)
public class ConcurrentSessionControlStrategyTests {

	@Mock
	SessionRegistry sessionRegistry;
	@Mock
	SessionAuthenticationStrategy sas;

	@Test
	public void deprecated() {
		List<SessionAuthenticationStrategy> delegates = new ArrayList<SessionAuthenticationStrategy>();
		delegates.add(new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry));
		delegates.add(new SessionFixationProtectionStrategy());
		delegates.add(new RegisterSessionAuthenticationStrategy(sessionRegistry));
		CompositeSessionAuthenticationStrategy strategy = new CompositeSessionAuthenticationStrategy(delegates);
	}

}