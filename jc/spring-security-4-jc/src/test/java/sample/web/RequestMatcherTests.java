package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcherEditor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RequestMatcherTests {

	@Test
	public void contextLoads() {}

	@Configuration
	static class Config {

		@Bean
		public RequestMatcher ant() {
			return new AntPathRequestMatcher("/**");
		}

		@Bean
		public RequestMatcher any() {
			return AnyRequestMatcher.INSTANCE;
		}

		@Bean
		public RequestMatcher el() {
			return new ELRequestMatcher("true");
		}

		@Bean
		public RequestMatcher ip() {
			return new IpAddressMatcher("192.168.1.1");
		}

		@Bean
		public RequestMatcherEditor editor() {
			return new RequestMatcherEditor();
		}

		@Bean
		public RequestMatcher regex() {
			return new RegexRequestMatcher(".*", null);
		}
	}
}