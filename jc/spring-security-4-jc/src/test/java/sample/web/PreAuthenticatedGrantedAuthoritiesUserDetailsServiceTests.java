package sample.web;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;

public class PreAuthenticatedGrantedAuthoritiesUserDetailsServiceTests {
	private static final String CUSTOM_USERNAME = "custom";

	@Test
	public void overrideCreateUserDetails() {
		SubclassPreAuthenticatedGrantedAuthoritiesUserDetailsService service = new SubclassPreAuthenticatedGrantedAuthoritiesUserDetailsService();

		PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(CUSTOM_USERNAME+"NOTSAME", "pass");
		token.setDetails(new PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(new MockHttpServletRequest(), AuthorityUtils.createAuthorityList("ROLE_USER")));

		UserDetails userDetails = service.loadUserDetails(token);

		assertThat(userDetails.getUsername()).isEqualTo(CUSTOM_USERNAME);
	}

	static class SubclassPreAuthenticatedGrantedAuthoritiesUserDetailsService extends PreAuthenticatedGrantedAuthoritiesUserDetailsService {

		@Override
		protected UserDetails createUserDetails(Authentication token,
				Collection<? extends GrantedAuthority> authorities) {
			return new User(CUSTOM_USERNAME, "notused", authorities);
		}
	}
}