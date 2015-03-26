package sample.core;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.ConsensusBased;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AbstractAccessDecisionManagerTests {
	@Autowired
	List<AccessDecisionManager> adm;

	List<AccessDecisionVoter<? extends Object>> voters;

	@Before
	public void setup() {
		voters = Arrays.<AccessDecisionVoter<? extends Object>>asList(mock(AccessDecisionVoter.class));
	}

	@Test
	public void configLoads() {
	}

	@Test
	public void affirmativeBased() {
		AffirmativeBased adm = new AffirmativeBased(voters);
	}

	@Test
	public void consensusBased() {
		ConsensusBased adm = new ConsensusBased(voters);
	}

	@Test
	public void unanimousBased() {
		UnanimousBased adm = new UnanimousBased(voters);
	}
}
