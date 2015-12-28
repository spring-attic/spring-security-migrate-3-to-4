package sample.openid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.openid.OpenID4JavaConsumer;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.RegexBasedAxFetchListFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class OpenID4JavaConsumerTests {

	List<OpenIDAttribute> attributes;

	@Before
	public void setup() {
		attributes = Arrays.asList(new OpenIDAttribute("email", "http://axschema.org/contact/email"));
	}

	@Test
	public void configLoads() {}

	@Test
	public void constructor() throws Exception {
		Map<String, List<OpenIDAttribute>> regexMap = new HashMap<String,List<OpenIDAttribute>>();
		regexMap.put(".*", attributes);
		RegexBasedAxFetchListFactory factory = new RegexBasedAxFetchListFactory(regexMap);
		new OpenID4JavaConsumer(factory);
	}
}