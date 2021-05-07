package tseo.sf82015.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
