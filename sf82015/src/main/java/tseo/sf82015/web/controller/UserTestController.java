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

import tseo.sf82015.model.Test;
import tseo.sf82015.model.User;
import tseo.sf82015.model.UserTest;
import tseo.sf82015.service.TestService;
import tseo.sf82015.service.UserService;
import tseo.sf82015.service.UserTestService;
import tseo.sf82015.web.dto.TestDTO;
import tseo.sf82015.web.dto.UserTestDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "userTest")
public class UserTestController {
	
	@Autowired 
	UserTestService userTestService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserTestDTO> getUserTest(@PathVariable Long id) {
		if (userTestService.findOne(id) == null) {
			return new ResponseEntity<UserTestDTO>(HttpStatus.NOT_FOUND);
		}	
		UserTest userTest = userTestService.findOne(id);
	
		return new ResponseEntity<UserTestDTO>(new UserTestDTO(userTest), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUserTests", method = RequestMethod.GET)
	public ResponseEntity<List<UserTestDTO>> getUserTests() {
		List<UserTest> userTests = userTestService.findAll();

		if (userTests.equals(null))
			return new ResponseEntity<List<UserTestDTO>>(HttpStatus.NOT_FOUND);
		
		List<UserTestDTO> userTestsDTO = new ArrayList<UserTestDTO>();
		for (UserTest ut : userTests) {
			userTestsDTO.add(new UserTestDTO(ut));
		}
		return new ResponseEntity<List<UserTestDTO>>(userTestsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addUserTest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserTestDTO> addUserTest(@RequestBody TestDTO testDTO) {
		if(testDTO == null) {
			return new ResponseEntity<UserTestDTO>(HttpStatus.BAD_REQUEST);
		}
		User loggedUser = userService.getLoggedUser();
		Test test = testService.findOne(testDTO.getId());
		UserTest userTest = new UserTest();
		
		userTest.setTest(test);
		userTest.setUserStudentSignedUp(loggedUser);
		//userTest.setPoints(0);
		userTest.setDateCreated(new Date());
		userTest.setStatus("N/A");
		userTest.setSignedUpStatus("SIGNEDUP");
		
		userTest = userTestService.save(userTest);
		
		if (userTest != null) {
			return new ResponseEntity<UserTestDTO>(new UserTestDTO(userTest), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserTestDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserTestDTO> delete(@PathVariable Long id) {		
		UserTest userTest = userTestService.findOne(id);
		
		if(userTest == null)
			return new ResponseEntity<UserTestDTO>(HttpStatus.NOT_FOUND);
									
		userTestService.delete(userTest);
		return new ResponseEntity<UserTestDTO>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getMyUserTestsNotGraded", method = RequestMethod.GET)
	public ResponseEntity<List<UserTestDTO>> getMyUserTestsNotGraded() {
		List<UserTest> userTests = userTestService.findAll();
		List<UserTest> myUserTestsNotGraded = new ArrayList<UserTest>();

		if (userTests.equals(null))
			return new ResponseEntity<List<UserTestDTO>>(HttpStatus.NOT_FOUND);
		
		//User loggedUser = userService.getCurrentUser();
		User loggedUser = userService.getLoggedUser();
		
		for(UserTest ut: userTests) {
			if(ut.getUserStudentSignedUp().getId() == loggedUser.getId() && ut.getStatus().equals("N/A")) {
				myUserTestsNotGraded.add(ut);
			}
		}
		
		List<UserTestDTO> userTestsDTO = new ArrayList<UserTestDTO>();
		for (UserTest ut : myUserTestsNotGraded) {
			userTestsDTO.add(new UserTestDTO(ut));
		}
		return new ResponseEntity<List<UserTestDTO>>(userTestsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUserTestsProfessor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserTestDTO>> getUserTestsProfessor(@RequestBody TestDTO testDTO) {
		if(testDTO == null) {
			return new ResponseEntity<List<UserTestDTO>>(HttpStatus.BAD_REQUEST);
		}
		User loggedUser = userService.getLoggedUser();
		Test test = testService.findOne(testDTO.getId());
		List<UserTest> userTests = userTestService.findAll();
		List<UserTest> myUserTestsProfessor = new ArrayList<UserTest>();
		List<UserTestDTO> userTestsDTO = new ArrayList<UserTestDTO>();
		
		
		for(UserTest ut: userTests) {
			if(test.getId() == ut.getTest().getId()) {
				myUserTestsProfessor.add(ut);
			}
		}
		
		for(UserTest ut: myUserTestsProfessor) {
			userTestsDTO.add(new UserTestDTO(ut));
		}
		
		return new ResponseEntity<List<UserTestDTO>>(userTestsDTO, HttpStatus.OK);
	}
	


}