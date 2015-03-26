package sample.core;

import org.junit.Test;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationExceptionTests {
	private final String message = "Test";
	private final Object userDetails = new User("user","notused", AuthorityUtils.createAuthorityList("ROLE_USER"));

	@Test
	public void accountStatusSubclass() {
		new AccountStatusException(message, userDetails) {};
	}

	@Test
	public void accountExpired() {
		new AccountExpiredException(message, userDetails);
	}

	@Test
	public void badCredentials() {
		new BadCredentialsException(message, userDetails);
	}

	@Test
	public void credentialsExpired() {
		new CredentialsExpiredException(message, userDetails);
	}

	@Test
	public void disabled() {
		new DisabledException(message, userDetails);
	}

	@Test
	public void locked() {
		new LockedException(message, userDetails);
	}

	@Test
	public void usernameNotFound() {
		new UsernameNotFoundException(message, userDetails);
	}
}