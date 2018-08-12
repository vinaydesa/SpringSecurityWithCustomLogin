package SpringSecurityAppBasedLogin.persistence.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_previleges", joinColumns = @JoinColumn(name = "role_key", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "previlage_key", referencedColumnName = "id"))
	private Set<Previlege> previleges;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Set<Previlege> getPrevileges() {
		return previleges;
	}

	public void setPrevileges(Set<Previlege> previleges) {
		this.previleges = previleges;
	}

}
