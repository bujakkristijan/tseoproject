package tseo.sf82015.web.controller;

import java.util.ArrayList;
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
import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;
import tseo.sf82015.service.UserService;
import tseo.sf82015.web.dto.LoginDTO;
import tseo.sf82015.web.dto.PaymentDTO;
import tseo.sf82015.web.dto.UserDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/admin")
public class UserController {
	
	@Autowired
	UserService userService;
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		if (userService.findOne(id) == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}	
		User user = userService.findOne(id);
	
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<User> users = userService.findAll();

		if (users.equals(null))
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
		
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User us : users) {
			usersDTO.add(new UserDTO(us));
		}
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getStudents() {
		List<User> users = userService.findAll();
		List<User> students = new ArrayList<User>();
		List<UserDTO> studentsDTO = new ArrayList<UserDTO>();

		if (users.equals(null))
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);

		//for (int i = 0; i < users.size(); i++)
		//	if (users.get(i).getRole().equals(Role.STUDENT))
		//		students.add(users.get(i));
		for(User us: users) {
			if(us.getRole().equals("STUDENT")) {
				studentsDTO.add(new UserDTO(us));
			}
		}
		
		return new ResponseEntity<List<UserDTO>>(studentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getProfessors", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getProfessors() {
		List<User> users = userService.findAll();
		List<UserDTO> professorsDTO = new ArrayList<UserDTO>();

		if (users.equals(null))
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
	
		
		for(User us: users) {
			if(us.getRole().equals("PROFESSOR") || us.getRole().equals("TEACHING_ASSISTANT") || us.getRole().equals("DEMONSTRATOR")) {
				professorsDTO.add(new UserDTO(us));
			}
		}

		return new ResponseEntity<List<UserDTO>>(professorsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		if(userDTO == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		if(userDTO.getRole().equals("STUDENT") && userDTO.getIndexNum() == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		if(userDTO.getEmail() == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		if(userService.findByEmail(userDTO.getEmail()) != null){
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		
		if(userDTO.getRole().equals("STUDENT") && userService.findByIndexNum(userDTO.getIndexNum()) != null){
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		User user = new User();
		
		user.setName(userDTO.getName());
		user.setRole(userDTO.getRole()); 
		user.setIndexNum(userDTO.getIndexNum());
		user.setPassword(userDTO.getPassword());
		user.setSurname(userDTO.getSurname());
		user.setEmail(userDTO.getEmail());
		
		user = userService.save(user);
		
		if (user != null) {
			return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@CrossOrigin(origins = "http://localhost:4200")	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> edit(@RequestBody UserDTO userDTO) {
		User user = userService.findOne(userDTO.getId()); 
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(userDTO.getRole().equals("STUDENT") && userDTO.getIndexNum() == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		if(userDTO.getEmail() == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		if(userService.findByEmail(userDTO.getEmail()) != null){
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		
		if(userDTO.getRole().equals("STUDENT") && userService.findByIndexNum(userDTO.getIndexNum()) != null){
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setIndexNum(userDTO.getIndexNum());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setRole(userDTO.getRole());
		userService.save(user);// proveriti zasto ne more student = ...
		
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> delete(@PathVariable Long id) {		
		User user = userService.findOne(id);
		
		if(user == null)
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
									
		userService.delete(user);
		return new ResponseEntity<UserDTO>(HttpStatus.OK);
	}
	
	
	
	


}
