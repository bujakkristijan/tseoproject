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
import tseo.sf82015.model.UserCourse;
import tseo.sf82015.service.CourseService;
import tseo.sf82015.service.UserCourseService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.UserCourseDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "userCourse")
public class UserCourseController {
	
	@Autowired 
	UserCourseService userCourseService;
	
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
			if(uc.getUser().getRole().equals(Role.PROFESSOR) || uc.getUser().getRole().equals(Role.DEMONSTRATOR)
					|| uc.getUser().getRole().equals(Role.TEACHING_ASSISTANT)){
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
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserCourseDTO> delete(@PathVariable Long id) {		
		UserCourse userCourse = userCourseService.findOne(id);
		
		if(userCourse == null)
			return new ResponseEntity<UserCourseDTO>(HttpStatus.NOT_FOUND);
									
		userCourseService.delete(userCourse);
		return new ResponseEntity<UserCourseDTO>(HttpStatus.OK);
	}

}