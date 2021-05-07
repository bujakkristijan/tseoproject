package tseo.sf82015.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.UserTest;


@Service
@Transactional
public interface UserTestService {
	
	UserTest findOne(Long id);
	List<UserTest> findAll();
	
	UserTest save(UserTest userTest);
	UserTest delete(UserTest userTest);

}
