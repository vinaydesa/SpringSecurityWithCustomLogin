package SpringSecurityAppBasedLogin.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringSecurityAppBasedLogin.persistence.entity.Previlege;


@Repository
public interface PrevilegeRepo extends JpaRepository<Previlege, Long>{	

}
