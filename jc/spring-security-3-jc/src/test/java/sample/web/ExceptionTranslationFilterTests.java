package sample.web;

import org.junit.Test;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

public class ExceptionTranslationFilterTests {

	@Test
	public void deprecatedSetters() {
		RequestCache requestCache = new NullRequestCache();
		AuthenticationEntryPoint entryPoint = new Http403ForbiddenEntryPoint();

		ExceptionTranslationFilter filter = new ExceptionTranslationFilter(entryPoint, requestCache);
	}
}
