package SpringSecurityAppBasedLogin.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "users_roles")
public class UserRole {

	@EmbeddedId
	private UserRoleComposite userRoleId;

	public UserRoleComposite getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(UserRoleComposite userRoleId) {
		this.userRoleId = userRoleId;
	}

}
