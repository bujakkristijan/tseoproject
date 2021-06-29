package tseo.sf82015.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;
import tseo.sf82015.repository.UserRepository;
import tseo.sf82015.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public User loggedUser;
	
	@Override
	public void setCurrentUser(User user) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		Authentication authentication = new PreAuthenticatedAuthenticationToken(user.getId(), null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Long id = Long.parseLong(auth.getName());
		
	}

	@Override
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			Long id = Long.parseLong(auth.getName());
			return userRepository.getOne(id);
			//return userRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void setLoggedUser(User user) {
		this.loggedUser = user;
	}
	
	
	
	@Override
	public User getLoggedUser() {
		return this.loggedUser;
	}
	
	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public List<User> findByRole(Role role) {
		return userRepository.findByRole(role);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User delete(User user) {
		if(user == null) 
			throw new IllegalArgumentException("Attempt to delete non-existing user.");
		
		userRepository.delete(user);
		return user;
	}

	@Override
	public User findByIndexNum(String indexNum) {
		return userRepository.findByIndexNum(indexNum);
	}
}
