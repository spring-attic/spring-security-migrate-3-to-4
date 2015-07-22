package sample.core;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public class SecurityConfigTests {

	@Test
	public void createSingleAttributeList() {
		List<ConfigAttribute> attrs =
				SecurityConfig.createList("ROLE_USER");

		assertThat(attrs).onProperty("attribute").containsOnly("ROLE_USER");
	}
}