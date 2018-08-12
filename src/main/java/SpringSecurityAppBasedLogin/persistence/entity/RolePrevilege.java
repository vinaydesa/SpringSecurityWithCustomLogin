package SpringSecurityAppBasedLogin.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity(name = "roles_previleges")
public class RolePrevilege {

	@EmbeddedId
	private RolePrevilegeComposite rolePrevilageKey;

	public RolePrevilegeComposite getRolePrevilageKey() {
		return rolePrevilageKey;
	}

	public void setRolePrevilageKey(RolePrevilegeComposite rolePrevilageKey) {
		this.rolePrevilageKey = rolePrevilageKey;
	}

}
