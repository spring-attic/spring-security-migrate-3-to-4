package sample.web;

import javax.servlet.Filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.session.ConcurrentSessionFilter;

@RunWith(MockitoJUnitRunner.class)
public class ConcurrentSessionFilterTests {
	@Mock
	SessionRegistry sessionRegistry;
	@Mock
	Filter filter;

	@Test
	public void deprecated() {
		ConcurrentSessionFilter filter = new ConcurrentSessionFilter(sessionRegistry,"/expired");
	}
}