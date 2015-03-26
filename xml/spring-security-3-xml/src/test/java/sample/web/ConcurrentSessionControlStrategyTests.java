package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
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
		ConcurrentSessionControlStrategy strategy = new ConcurrentSessionControlStrategy(sessionRegistry);
	}

}