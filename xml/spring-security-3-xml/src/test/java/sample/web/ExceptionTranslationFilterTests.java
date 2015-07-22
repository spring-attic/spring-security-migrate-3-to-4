package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ExceptionTranslationFilterTests {
	@Autowired
	ExceptionTranslationFilter etf;

	@Test
	public void configLoads() {}

	@Test
	public void deprecatedSetters() {
		RequestCache requestCache = new NullRequestCache();
		AuthenticationEntryPoint entryPoint = new Http403ForbiddenEntryPoint();

		ExceptionTranslationFilter filter = new ExceptionTranslationFilter(entryPoint, requestCache);
	}
}
