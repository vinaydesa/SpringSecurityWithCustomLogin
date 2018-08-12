package SpringSecurityAppBasedLogin.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringSecurityAppBasedLogin.persistence.entity.Role;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Long>{

}
