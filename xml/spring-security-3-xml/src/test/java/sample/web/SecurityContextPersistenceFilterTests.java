package sample.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SecurityContextPersistenceFilterTests {
	@Autowired
	SecurityContextRepository securityContextRepository;

	@Test
	public void configLoads() {}

	@Test
	public void deprecated() {
		SecurityContextPersistenceFilter filter = new SecurityContextPersistenceFilter(securityContextRepository);
	}

}