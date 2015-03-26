package sample.acl;

import net.sf.ehcache.Ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;

@RunWith(MockitoJUnitRunner.class)
public class EhCacheBasedAclCacheTests {

	@Mock
	Ehcache ehCache;

	@Test
	public void constructor() throws Exception {
		new EhCacheBasedAclCache(ehCache);
	}
}