package tseo.sf82015.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	List<User> findByRole(Role role);
	User findByIndexNum(String indexNum);
}
