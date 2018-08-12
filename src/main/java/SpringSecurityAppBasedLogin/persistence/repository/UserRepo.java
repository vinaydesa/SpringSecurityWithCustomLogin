package SpringSecurityAppBasedLogin.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringSecurityAppBasedLogin.persistence.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserId(String userId);
}
