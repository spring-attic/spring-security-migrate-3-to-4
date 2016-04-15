package sample.acl;

import net.sf.ehcache.Ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.domain.AclAuthorizationStrategyImpl;
import org.springframework.security.acls.domain.AuditLogger;
import org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RunWith(MockitoJUnitRunner.class)
public class EhCacheBasedAclCacheTests {

	@Mock
	Ehcache ehCache;
	@Mock
	AuditLogger auditLogger;

	@Test
	public void constructor() throws Exception {
		PermissionGrantingStrategy permissionGrantingStrategy =
				new DefaultPermissionGrantingStrategy(auditLogger);
		AclAuthorizationStrategy aclAuthorizationStrategy =
				new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority("ROLE_ACL_ADMIN"));
		new EhCacheBasedAclCache(ehCache, permissionGrantingStrategy, aclAuthorizationStrategy);
	}
}