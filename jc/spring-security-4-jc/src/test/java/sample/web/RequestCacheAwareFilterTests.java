package sample.web;

import javax.servlet.Filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RequestCacheAwareFilterTests {
	@Autowired
	RequestCache requestCache;
	@Autowired
	Filter filter;

	@Test
	public void configLoads() {}

	@Configuration
	static class Config {

		@Bean
		public RequestCacheAwareFilter rememberMeAuthenticationFilter(RequestCache requestCache) {
			RequestCacheAwareFilter filter = new RequestCacheAwareFilter(requestCache);
			return filter;
		}

		@Bean
		public RequestCache requestCache() {
			return new NullRequestCache();
		}
	}
}