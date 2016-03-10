package sample.web;

import javax.servlet.Filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Test
	public void deprecated() {
		RequestCacheAwareFilter filter = new RequestCacheAwareFilter(requestCache);
	}
}