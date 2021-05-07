package tseo.sf82015.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.UserCourse;
import tseo.sf82015.model.UserTest;
import tseo.sf82015.repository.UserCourseRepository;
import tseo.sf82015.repository.UserTestRepository;
import tseo.sf82015.service.UserCourseService;

@Service
@Transactional
public class UserCourseServiceImpl implements UserCourseService{
	
	@Autowired
	UserCourseRepository userCourseRepository;
	
	@Override
	public UserCourse findOne(Long id) {
		return userCourseRepository.findById(id).get();
	}

	@Override
	public List<UserCourse> findAll() {
		return userCourseRepository.findAll();
	}

	@Override
	public UserCourse save(UserCourse userCourse) {
		return userCourseRepository.save(userCourse);
	}
	
	@Override
	public UserCourse delete(UserCourse userCourse) {
		if(userCourse == null) 
			throw new IllegalArgumentException("Attempt to delete non-existing course.");
		
		userCourseRepository.delete(userCourse);
		return userCourse;
	}

}
