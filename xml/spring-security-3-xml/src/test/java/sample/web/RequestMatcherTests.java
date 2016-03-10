package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Test
	public void deprecated() {
		RequestMatcher matcher = null;
	}

	@Test
	public void ant() {
		new AntPathRequestMatcher("/**");
	}

	@Test
	public void any() {
		RequestMatcher matcher = AnyRequestMatcher.INSTANCE;
	}

	@Test
	public void el() {
		ELRequestMatcher matcher = new ELRequestMatcher("true");
	}

	@Test
	public void ip() {
		IpAddressMatcher matcher = new IpAddressMatcher("192.168.1.1");
	}

	@Test
	public void editor() {
		RequestMatcherEditor editor = new RequestMatcherEditor();
	}

	@Test
	public void regex() {
		RegexRequestMatcher editor = new RegexRequestMatcher(".*", null);
	}
}