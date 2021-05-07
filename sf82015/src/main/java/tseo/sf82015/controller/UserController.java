package tseo.sf82015.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;
import tseo.sf82015.service.UserService;

@RestController
@RequestMapping(value = "api/admin")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		if (userService.findOne(id) == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<User>(userService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();

		if (users.equals(null))
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getStudents() {
		List<User> users = userService.findAll();
		List<User> students = new ArrayList<User>();

		if (users.equals(null))
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);

		for (int i = 0; i < users.size(); i++)
			if (users.get(i).getRole().equals(Role.STUDENT))
				students.add(users.get(i));
		
		return new ResponseEntity<List<User>>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getProfessors", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getProfessors() {
		List<User> users = userService.findAll();
		List<User> professors = new ArrayList<User>();

		if (users.equals(null)) 
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	
		for (int i = 0; i < users.size(); i++)
			if (users.get(i).getRole().equals(Role.PROFESSOR) || users.get(i).getRole().equals(Role.TEACHING_ASSISTANT) || users.get(i).getRole().equals(Role.DEMONSTRATOR))
				professors.add(users.get(i));

		return new ResponseEntity<List<User>>(professors, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User request) {
		if(request == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
		request.setRole(request.getRole()); 
		
		User us = userService.save(request);
		
		if (us != null) {
			return new ResponseEntity<User>(us, HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
		
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> edit(@RequestBody User request) {
		if(request == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		User user = userService.findOne(request.getId());
		user.setName(request.getName());
		user.setSurname(request.getSurname());
		user.setIndexNum(request.getIndexNum());
		user.setPassword(request.getPassword());
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable Long id) {		
		User user = userService.findOne(id);
		
		if(user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
									
		userService.delete(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
