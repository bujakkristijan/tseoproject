package tseo.sf82015.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;
import tseo.sf82015.model.UserCourse;
import tseo.sf82015.service.CourseService;
import tseo.sf82015.service.UserCourseService;
import tseo.sf82015.service.UserService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.UserCourseDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "userCourse")
public class UserCourseController {
	
	@Autowired 
	UserCourseService userCourseService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserCourseDTO> getUserCourse(@PathVariable Long id) {
		if (userCourseService.findOne(id) == null) {
			return new ResponseEntity<UserCourseDTO>(HttpStatus.NOT_FOUND);
		}	
		UserCourse userCourse = userCourseService.findOne(id);
	
		return new ResponseEntity<UserCourseDTO>(new UserCourseDTO(userCourse), HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getProfessorsOnCourses", method = RequestMethod.GET)
	public ResponseEntity<List<UserCourseDTO>> getUserCourses() {
		List<UserCourse> userCourses = userCourseService.findAll();

		if (userCourses.equals(null))
			return new ResponseEntity<List<UserCourseDTO>>(HttpStatus.NOT_FOUND);
		
		List<UserCourseDTO> userCoursesDTO = new ArrayList<UserCourseDTO>();
		for (UserCourse uc : userCourses) {
			if(uc.getUser().getRole().equals("PROFESSOR") || uc.getUser().getRole().equals("DEMONSTRATOR")
					|| uc.getUser().getRole().equals("TEACHING_ASSISTANT")){
				userCoursesDTO.add(new UserCourseDTO(uc));
			}
			
		}
		return new ResponseEntity<List<UserCourseDTO>>(userCoursesDTO, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addUserCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserCourseDTO> addUserCourse(@RequestBody UserCourseDTO userCourseDTO) {
		if(userCourseDTO == null) {
			return new ResponseEntity<UserCourseDTO>(HttpStatus.BAD_REQUEST);
		}
		if(userCourseDTO.getCourse() == null) {
			return new ResponseEntity<UserCourseDTO>(HttpStatus.BAD_REQUEST);
		}
		if(userCourseDTO.getUser() == null) {
			return new ResponseEntity<UserCourseDTO>(HttpStatus.BAD_REQUEST);
		}
		UserCourse userCourse = new UserCourse();
		System.out.println(userCourseDTO.getCourse().getName() + "/////" + userCourseDTO.getUser().getName());
		userCourse.setCourse(userCourseDTO.getCourse());
		userCourse.setUser(userCourseDTO.getUser()); 
		userCourse.setDateAdded(new Date());
		
		userCourse = userCourseService.save(userCourse);
		
		if (userCourse != null) {
			return new ResponseEntity<UserCourseDTO>(new UserCourseDTO(userCourse), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserCourseDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addStudentCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> addStudentCourse(@RequestBody CourseDTO courseDTO) {
		if(courseDTO == null) {
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
		//User user = userService.getCurrentUser();
		User user = userService.getLoggedUser();
		Course course = courseService.findOne(courseDTO.getId());
		UserCourse userCourse = new UserCourse();
		//System.out.println(userCourseDTO.getCourse().getName() + "/////" + userCourseDTO.getUser().getName());
		userCourse.setCourse(course);
		userCourse.setUser(user); 
		userCourse.setDateAdded(new Date());
		
		userCourse = userCourseService.save(userCourse);
		
		
		
		if (userCourse != null) {
			return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserCourseDTO> delete(@PathVariable Long id) {		
		UserCourse userCourse = userCourseService.findOne(id);
		
		if(userCourse == null)
			return new ResponseEntity<UserCourseDTO>(HttpStatus.NOT_FOUND);
									
		userCourseService.delete(userCourse);
		return new ResponseEntity<UserCourseDTO>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "students/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserCourseDTO>> getUserCoursesOnCourse(@PathVariable Long courseId) {
		
		if (courseService.findOne(courseId) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		Course course = courseService.findOne(courseId);
		List<UserCourse> userCourses = new ArrayList<UserCourse>();
		List<UserCourse> studentsOnCourse = new ArrayList<UserCourse>();
		userCourses = userCourseService.findAll();
		
		for(UserCourse uc: userCourses) {
			if(uc.getCourse().getId() == course.getId() && uc.getUser().getRole().equals("STUDENT")) {
				studentsOnCourse.add(uc);
			}
		}
		List<UserCourseDTO> studentsOnCourseDTO = new ArrayList<UserCourseDTO>();
		
		for(UserCourse uc: studentsOnCourse) {
			studentsOnCourseDTO.add(new UserCourseDTO(uc));
		}
		
		return new ResponseEntity<List<UserCourseDTO>>(studentsOnCourseDTO, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "professors/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserCourseDTO>> getProfessorCoursesOnCourse(@PathVariable Long courseId) {
		
		if (courseService.findOne(courseId) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		Course course = courseService.findOne(courseId);
		List<UserCourse> userCourses = new ArrayList<UserCourse>();
		List<UserCourse> professorsOnCourse = new ArrayList<UserCourse>();
		userCourses = userCourseService.findAll();
		
		for(UserCourse uc: userCourses) {
			if(uc.getCourse().getId() == course.getId()) {
				if(uc.getUser().getRole().equals("PROFESSOR") || uc.getUser().getRole().equals("TEACHING_ASSISTANT")
						|| uc.getUser().getRole().equals("DEMONSTRATOR")) {
					professorsOnCourse.add(uc);
				}
				
			}
		}
		List<UserCourseDTO> professorsOnCourseDTO = new ArrayList<UserCourseDTO>();
		
		for(UserCourse uc: professorsOnCourse) {
			professorsOnCourseDTO.add(new UserCourseDTO(uc));
		}
		
		return new ResponseEntity<List<UserCourseDTO>>(professorsOnCourseDTO, HttpStatus.OK);
	}

}