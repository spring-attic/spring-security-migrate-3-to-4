package sample.core;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsWrapperTests {

	@Test
	public void test() {
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		UserDetails userDetails = new User("admin", "notused", authorities);
		RoleHierarchyImpl roleHiearchy = new RoleHierarchyImpl();
		roleHiearchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

		Collection<GrantedAuthority> allAuthorities =
				roleHiearchy.getReachableGrantedAuthorities(userDetails.getAuthorities());
		UserDetails authenticate =
				new User(userDetails.getUsername(), userDetails.getPassword(), allAuthorities);

		assertThat(authenticate.getAuthorities()).onProperty("authority").containsOnly("ROLE_USER","ROLE_ADMIN");
	}
}
