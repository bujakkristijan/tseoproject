package tseo.sf82015.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;

@Service
@Transactional
public interface UserService {
	
	public void setCurrentUser(User user);
    public User getCurrentUser();
    
    public void setLoggedUser(User user);
    public User getLoggedUser();
    
	User findOne(Long id);
	User findByEmail(String email);
	User findByIndexNum(String indexNum);
	List<User> findAll();
	List<User> findByRole(Role role);
	
	User save(User user);
	User delete(User user);

}
