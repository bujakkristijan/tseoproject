package tseo.sf82015.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.UserTest;
import tseo.sf82015.repository.UserTestRepository;
import tseo.sf82015.service.UserTestService;

@Service
@Transactional
public class UserTestServiceImpl implements UserTestService{
	
	@Autowired
	UserTestRepository userTestRepository;
	
	@Override
	public UserTest findOne(Long id) {
		return userTestRepository.findById(id).get();
	}

	@Override
	public List<UserTest> findAll() {
		return userTestRepository.findAll();
	}

	@Override
	public UserTest save(UserTest userTest) {
		return userTestRepository.save(userTest);
	}
	
	@Override
	public UserTest delete(UserTest userTest) {
		if(userTest == null) 
			throw new IllegalArgumentException("Attempt to delete non-existing test.");
		
		userTestRepository.delete(userTest);
		return userTest;
	}

}
