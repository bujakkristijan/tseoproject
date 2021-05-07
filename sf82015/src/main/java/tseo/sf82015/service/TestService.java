package tseo.sf82015.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.Test;

@Service
@Transactional
public interface TestService {

	Test findOne(Long id);
	List<Test> findAll();
	
	Test save(Test test);
	Test delete(Test test);
	
}
