package sample.core;

import org.junit.Test;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;

public class AnonymousAuthenticationProviderTests {

	final String key = "key";

	@Test
	public void constructor() {
		AnonymousAuthenticationProvider provider = new AnonymousAuthenticationProvider(key);
	}
}
