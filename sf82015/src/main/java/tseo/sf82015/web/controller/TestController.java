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
import tseo.sf82015.model.Test;
import tseo.sf82015.model.User;
import tseo.sf82015.model.UserTest;
import tseo.sf82015.service.CourseService;
import tseo.sf82015.service.TestService;
import tseo.sf82015.service.UserService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.TestDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "test")
public class TestController {
	
	@Autowired 
	TestService testService;
	
	@Autowired 
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TestDTO> getTest(@PathVariable Long id) {
		if (testService.findOne(id) == null) {
			return new ResponseEntity<TestDTO>(HttpStatus.NOT_FOUND);
		}	
		Test test = testService.findOne(id);
	
		return new ResponseEntity<TestDTO>(new TestDTO(test), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getTests", method = RequestMethod.GET)
	public ResponseEntity<List<TestDTO>> getTests() {
		List<Test> tests = testService.findAll();

		if (tests.equals(null))
			return new ResponseEntity<List<TestDTO>>(HttpStatus.NOT_FOUND);
		
		List<TestDTO> testsDTO = new ArrayList<>();
		for (Test t : tests) {
			testsDTO.add(new TestDTO(t));
		}
		return new ResponseEntity<List<TestDTO>>(testsDTO, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/addTest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestDTO> addTest(@RequestBody TestDTO testDTO) {
		if(testDTO == null) {
			return new ResponseEntity<TestDTO>(HttpStatus.BAD_REQUEST);
		}
		Course course = courseService.findOne(testDTO.getCourse().getId());
		List<UserTest> userTests = new ArrayList<UserTest>();
		
		//User userLogged = userService.getCurrentUser();
		User userLogged = userService.getLoggedUser();
		
		if (course == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Test test = new Test();
		
		test.setTitle(testDTO.getTitle());
		test.setDescription(testDTO.getDescription());
		test.setDateCreated(new Date());
		test.setMaxPoints(testDTO.getMaxPoints());
		//test.setCourse(courseService.findOne(testDTO.getCourseDTO().getId()));
		test.setCourse(course);
		test.setUser(userLogged);
		
		//course.getTests().add(test);
		
		
		//test.setUserTests(userTests);
		
		test = testService.save(test);
		
		if (test != null) {
			return new ResponseEntity<TestDTO>(new TestDTO(test), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<TestDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestDTO> edit(@RequestBody TestDTO testDTO) {
		Test test = testService.findOne(testDTO.getId()); 
		if (test == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		test.setTitle(testDTO.getTitle());
		test.setDescription(testDTO.getDescription());
		test.setDateCreated(new Date());
		test.setMaxPoints(testDTO.getMaxPoints());
		//test.setCourse(testDTO.getCourse());
		
		test = testService.save(test);// proveriti zasto ne more student = ...
		
		return new ResponseEntity<TestDTO>(new TestDTO(test), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TestDTO> delete(@PathVariable Long id) {		
		Test test = testService.findOne(id);
		
		if(test == null)
			return new ResponseEntity<TestDTO>(HttpStatus.NOT_FOUND);
									
		testService.delete(test);
		return new ResponseEntity<TestDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getMyTests", method = RequestMethod.GET)
	public ResponseEntity<List<TestDTO>> getMyTests() {
		List<Test> tests = testService.findAll();
		List<Test> myTests = new ArrayList<Test>();
		User loggedUser = userService.getLoggedUser();
		if (tests.equals(null))
			return new ResponseEntity<List<TestDTO>>(HttpStatus.NOT_FOUND);
		for(Test t: tests) {
			if(t.getUser().getId() == loggedUser.getId()) {
				myTests.add(t);
			}
		}
		List<TestDTO> testsDTO = new ArrayList<>();
		for (Test t : myTests) {
			testsDTO.add(new TestDTO(t));
		}
		return new ResponseEntity<List<TestDTO>>(testsDTO, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200") // preko post metode saljem testove, zato sto saljem courseId, ne uzimam iz putanje
	@RequestMapping(value = "/getTestsForCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> getTestsForCourse(@RequestBody Course courseDTO) {
		if(courseDTO == null) {
			return new ResponseEntity<List<TestDTO>>(HttpStatus.BAD_REQUEST);
		}
		Course course = courseService.findOne(courseDTO.getId());
		
		if (course == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<Test> allTests = testService.findAll();
		List<Test> allTestsForCourse = new ArrayList<Test>();
		List<TestDTO> allTestsForCourseDTO = new ArrayList<TestDTO>();
		
		for(Test t: allTests) {
			if(t.getCourse().getId() == course.getId()) {
				allTestsForCourse.add(t);
			}
		}
		
		for(Test t: allTestsForCourse) {
			allTestsForCourseDTO.add(new TestDTO(t));
		}
		
		
		return new ResponseEntity<List<TestDTO>>(allTestsForCourseDTO, HttpStatus.OK);
		
	}

}
