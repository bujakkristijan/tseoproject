package tseo.sf82015.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.UserCourse;

@Service
@Transactional
public interface UserCourseService {
	
	UserCourse findOne(Long id);
	List<UserCourse> findAll();
	
	UserCourse save(UserCourse userCourse);
	UserCourse delete(UserCourse userCourse);

}
