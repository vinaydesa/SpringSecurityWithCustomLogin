package SpringSecurityAppBasedLogin.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRoleComposite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_key", nullable = false)
	private Long userKey;

	@Column(name = "role_key", nullable = false)
	private Long roleKey;

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

	public Long getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(Long roleKey) {
		this.roleKey = roleKey;
	}

}
