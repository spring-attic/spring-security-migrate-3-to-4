package sample.acl;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.domain.AclImpl;
import org.springframework.security.acls.domain.AuditLogger;
import org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.acls.model.Sid;


@RunWith(MockitoJUnitRunner.class)
public class AclImplTests {
	@Mock
	ObjectIdentity objectIdentity;
	@Mock
	AclAuthorizationStrategy aclAuthorizationStrategy;
	@Mock
	AuditLogger auditLogger;
	@Mock
	Acl parentAcl;
	final boolean entriesInheriting = true;
	@Mock
	Sid owner;
	@Mock
	List<Sid> loadedSids;
	Serializable id = "id";

	@Test
	public void constructor() {
		PermissionGrantingStrategy permissionGrantingStrategy =
				new DefaultPermissionGrantingStrategy(auditLogger);
		new AclImpl(objectIdentity, id, aclAuthorizationStrategy, permissionGrantingStrategy,
								parentAcl, loadedSids, entriesInheriting, owner);
	}
}
