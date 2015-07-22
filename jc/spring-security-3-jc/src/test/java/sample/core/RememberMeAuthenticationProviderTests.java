package sample.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;

@RunWith(MockitoJUnitRunner.class)
public class RememberMeAuthenticationProviderTests {
	final String key = "key";

	@Mock
	RememberMeAuthenticationProvider provider;

	@Test
	public void javaCompiles() {
		RememberMeAuthenticationProvider provider = new RememberMeAuthenticationProvider(key);
	}
}
