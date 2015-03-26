package sample.web;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;

public class SessionFixationProtectionStrategyTests {


	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MockFilterChain chain;
	Authentication user;

	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		chain = new MockFilterChain();
		user = new TestingAuthenticationToken("u", "p","ROLE_USER");
	}

	@Test
	public void deprecated() {
		final String SAVED_ATTR = "yes";
		final String REMOVED_ATTR = "no";

		request.getSession().setAttribute(SAVED_ATTR, "1");
		request.getSession().setAttribute(REMOVED_ATTR, "0");

		List<String> attrsToRetain = Arrays.asList(SAVED_ATTR);
		SessionFixationProtectionStrategy strategy = new AttrsSessionFixationProtectionStrategy(attrsToRetain);
		strategy.setMigrateSessionAttributes(false);

		strategy.onAuthentication(user, request, response);

		assertThat(request.getSession().getAttribute(SAVED_ATTR)).isNotNull();
		assertThat(request.getSession().getAttribute(REMOVED_ATTR)).isNull();
	}

	static class AttrsSessionFixationProtectionStrategy extends SessionFixationProtectionStrategy {
		private final Collection<String> attrsToRetain;

		public AttrsSessionFixationProtectionStrategy(
				Collection<String> attrsToRetain) {
			this.attrsToRetain = attrsToRetain;
		}

		@Override
		protected Map<String, Object> extractAttributes(HttpSession session) {
			Map<String,Object> attrs = new HashMap<String, Object>();
			for(String attr : attrsToRetain) {
				attrs.put(attr, session.getAttribute(attr));
			}
			return attrs;
		}

	}
}
