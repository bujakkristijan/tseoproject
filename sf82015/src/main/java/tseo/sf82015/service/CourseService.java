package tseo.sf82015.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.Course;


@Service
@Transactional
public interface CourseService {
	
	Course findOne(Long id);
	List<Course> findAll();
	
	Course save(Course course);
	Course delete(Course course);

}
