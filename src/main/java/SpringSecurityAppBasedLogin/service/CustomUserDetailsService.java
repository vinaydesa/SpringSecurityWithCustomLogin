package SpringSecurityAppBasedLogin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import SpringSecurityAppBasedLogin.persistence.entity.Role;
import SpringSecurityAppBasedLogin.persistence.entity.User;
import SpringSecurityAppBasedLogin.persistence.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepo.findByUserId(userId);

		if (user == null) {
			return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true,
					getAuthorities(new ArrayList<>()));
		} else {

			UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(userId);
			builder.password(user.getPassword());
			builder.roles(getRoles(user.getRoles()).toArray(new String[0]));
			return builder.build();
		}
	}

	private List<String> getRoles(Collection<Role> roleList) {
		List<String> roleStringList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(roleList)) {
			roleList.stream().forEach(role -> roleStringList.add(role.getName()));
		}
		return roleStringList;
	}

	private final Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			authorities.addAll(role.getPrevileges().stream().map(p -> new SimpleGrantedAuthority(p.getName()))
					.collect(Collectors.toList()));
		}
		return authorities;
	}

}
