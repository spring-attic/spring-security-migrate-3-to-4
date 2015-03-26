package sample.web;

import javax.servlet.Filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SessionManagementFilterTests {
	@Autowired
	SecurityContextRepository securityContextRepository;
	@Autowired
	SessionAuthenticationStrategy sessionAuthenticationStrategy;
	@Autowired
	Filter filter;

	@Test
	public void configLoads() {}

	@Test
	public void deprecated() {
		SessionManagementFilter filter = new SessionManagementFilter(securityContextRepository, sessionAuthenticationStrategy);
	}
}