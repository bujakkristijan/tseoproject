package tseo.sf82015.web.controller;

import java.util.ArrayList;
import java.util.Date;
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

import tseo.sf82015.model.UserCourse;
import tseo.sf82015.model.UserTest;
import tseo.sf82015.service.UserCourseService;
import tseo.sf82015.service.UserTestService;
import tseo.sf82015.web.dto.UserCourseDTO;
import tseo.sf82015.web.dto.UserTestDTO;

@RestController
@RequestMapping(value = "userTest")
public class UserTestController {
	
	@Autowired 
	UserTestService userTestService;
	
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
	public ResponseEntity<UserTestDTO> addUserTest(@RequestBody UserTestDTO userTestDTO) {
		if(userTestDTO == null) {
			return new ResponseEntity<UserTestDTO>(HttpStatus.BAD_REQUEST);
		}
		UserTest userTest = new UserTest();
		
		userTest.setTest(userTestDTO.getTest());
		userTest.setUserStudentSignedUp(userTestDTO.getUserStudentSignedUp());
		userTest.setPoints(0);
		userTest.setDateCreated(new Date());
		userTest.setStatus("N/A");
		
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

}