package tseo.sf82015.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.User;
import tseo.sf82015.service.CourseService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.UserDTO;

@RestController
@RequestMapping(value = "course")
public class CourseController {
	
	@Autowired 
	CourseService courseService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
		if (courseService.findOne(id) == null) {
			return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
		}	
		Course course = courseService.findOne(id);
	
		return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCourses", method = RequestMethod.GET)
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<Course> courses = courseService.findAll();

		if (courses.equals(null))
			return new ResponseEntity<List<CourseDTO>>(HttpStatus.NOT_FOUND);
		
		List<CourseDTO> coursesDTO = new ArrayList<>();
		for (Course c : courses) {
			coursesDTO.add(new CourseDTO(c));
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
		if(courseDTO == null) {
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
		Course course = new Course();
		
		course.setName(courseDTO.getName());
		course.setCode(courseDTO.getCode()); 
		course.setPrice(courseDTO.getPrice());
		course.setDescription(courseDTO.getDescription());
		
		course = courseService.save(course);
		
		if (course != null) {
			return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> edit(@RequestBody CourseDTO courseDTO) {
		Course course = courseService.findOne(courseDTO.getId()); 
		if (course == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		course.setName(courseDTO.getName());
		course.setCode(courseDTO.getCode()); 
		course.setPrice(courseDTO.getPrice());
		course.setDescription(courseDTO.getDescription());
		
		courseService.save(course);// proveriti zasto ne more student = ...
		
		return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CourseDTO> delete(@PathVariable Long id) {		
		Course course = courseService.findOne(id);
		
		if(course == null)
			return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
									
		courseService.delete(course);
		return new ResponseEntity<CourseDTO>(HttpStatus.OK);
	}

}
