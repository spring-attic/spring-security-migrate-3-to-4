package sample.openid;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.openid.OpenID4JavaConsumer;
import org.springframework.security.openid.OpenIDAttribute;

public class OpenID4JavaConsumerTests {

	List<OpenIDAttribute> attributes;

	@Before
	public void setup() {
		attributes = Arrays.asList(new OpenIDAttribute("email",
				"http://axschema.org/contact/email"));
	}

	@Test
	public void constructor() throws Exception {
		new OpenID4JavaConsumer(attributes);
	}
}