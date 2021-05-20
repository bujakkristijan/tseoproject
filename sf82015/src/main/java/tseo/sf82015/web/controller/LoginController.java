package tseo.sf82015.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tseo.sf82015.model.User;
import tseo.sf82015.service.UserService;

import tseo.sf82015.web.dto.LoginDTO;
import tseo.sf82015.web.dto.UserDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
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
			
			//System.out.println("user za setovanje: " + user);
			User getUser = userService.getCurrentUser();
			//this.loggedUser = getUser;
			userService.setLoggedUser(getUser);
			System.out.println("uzer setovani: " + getUser);
			
			return new ResponseEntity<>(loginDTO, HttpStatus.OK);
		} 
				
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getCurrentUserLoggedIn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getCurrentUserLoggedIn() {
		//User userLogged = userService.getCurrentUser();
		User userLogged = userService.getLoggedUser();
		if (userLogged == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}	
		UserDTO userDTO = new UserDTO(userLogged);
		System.out.println("Vraca ulogovanog usera: " + userDTO.getEmail() + " " + userDTO.getName());
		
	
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<LoginDTO> logout() {
		//if(userService.getCurrentUser() != null)
		//	SecurityContextHolder.clearContext();
		if(userService.getLoggedUser() != null) {
			userService.setCurrentUser(null);
		}
		LoginDTO loginDTO = new LoginDTO();
			
		return new ResponseEntity<LoginDTO>(loginDTO, HttpStatus.OK);
	}

}
