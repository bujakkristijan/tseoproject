package tseo.sf82015.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.Course;
import tseo.sf82015.repository.CourseRepository;
import tseo.sf82015.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Course findOne(Long id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}	
	
	@Override
	public Course delete(Course course) {
		if(course == null) 
			throw new IllegalArgumentException("Attempt to delete non-existing course.");
		
		courseRepository.delete(course);
		return course;
	}

}
