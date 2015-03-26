package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.AnyRequestMatcher;
import org.springframework.security.web.util.ELRequestMatcher;
import org.springframework.security.web.util.IpAddressMatcher;
import org.springframework.security.web.util.RegexRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.security.web.util.RequestMatcherEditor;
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
			return new AnyRequestMatcher();
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