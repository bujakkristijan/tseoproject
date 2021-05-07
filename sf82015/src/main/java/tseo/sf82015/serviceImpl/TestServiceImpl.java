package tseo.sf82015.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.Test;
import tseo.sf82015.repository.TestRepository;
import tseo.sf82015.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestRepository testRepository;
	
	@Override
	public Test findOne(Long id) {
		return testRepository.findById(id).get();
	}

	@Override
	public List<Test> findAll() {
		return testRepository.findAll();
	}

	@Override
	public Test save(Test test) {
		return testRepository.save(test);
	}
	
	@Override
	public Test delete(Test test) {
		if(test == null) 
			throw new IllegalArgumentException("Attempt to delete non-existing test.");
		
		testRepository.delete(test);
		return test;
	}

}
