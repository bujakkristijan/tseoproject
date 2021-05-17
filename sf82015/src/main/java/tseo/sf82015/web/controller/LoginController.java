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

import tseo.sf82015.model.Course;
import tseo.sf82015.model.User;
import tseo.sf82015.service.UserService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.LoginDTO;
import tseo.sf82015.web.dto.UserDTO;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDTO> loginCheck(@RequestBody LoginDTO loginDTO) {
		if(loginDTO == null)
			return new ResponseEntity<LoginDTO>(HttpStatus.NOT_FOUND);
		
		User user = userService.findByEmail(loginDTO.getEmail());
			
		if(user == null || !user.getPassword().equals(loginDTO.getPassword())) {
			System.out.println("Ne postoji korisnik sa unetom sifrom ili emailom");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		if (user.getPassword().equals(loginDTO.getPassword())) {
			userService.setCurrentUser(user);
			return new ResponseEntity<>(loginDTO, HttpStatus.OK);
		} 
				
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/getCurrentUserLoggedIn", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser() {
		User userLogged = userService.getCurrentUser();
		if (userLogged == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}	
		UserDTO userDTO = new UserDTO(userLogged);
		
	
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

}
