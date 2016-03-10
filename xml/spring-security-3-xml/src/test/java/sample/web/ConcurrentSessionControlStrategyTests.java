package sample.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ConcurrentSessionControlStrategyTests {

	@Autowired
	SessionRegistry sessionRegistry;

	@Autowired
	SessionAuthenticationStrategy sas;

	@Test
	public void configLoads() {}

	@Test
	public void deprecated() {
		List<SessionAuthenticationStrategy> delegates = new ArrayList<SessionAuthenticationStrategy>();
		delegates.add(new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry));
		delegates.add(new SessionFixationProtectionStrategy());
		delegates.add(new RegisterSessionAuthenticationStrategy(sessionRegistry));
		CompositeSessionAuthenticationStrategy strategy = new CompositeSessionAuthenticationStrategy(delegates);
	}

}