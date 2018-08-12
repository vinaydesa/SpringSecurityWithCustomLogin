package SpringSecurityAppBasedLogin.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RolePrevilegeComposite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "role_key")
	private Long roleKey;

	@Column(name = "previlage_key")
	private Long previlegeKey;

	public Long getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(Long roleKey) {
		this.roleKey = roleKey;
	}

	public Long getPrevilegeKey() {
		return previlegeKey;
	}

	public void setPrevilegeKey(Long previlegeKey) {
		this.previlegeKey = previlegeKey;
	}

}
