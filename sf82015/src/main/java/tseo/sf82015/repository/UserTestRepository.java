package tseo.sf82015.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tseo.sf82015.model.UserTest;

@Repository
public interface UserTestRepository extends JpaRepository<UserTest, Long> {

}
