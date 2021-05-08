package tseo.sf82015.web.dto;

import tseo.sf82015.model.Role;
import tseo.sf82015.model.User;

public class UserDTO {
	
	private Long id;
	private String name;
	private String surname;
	private String indexNum;
	private String email;
	private String password;
	private Role role;
	
	public UserDTO(Long id, String name, String surname, String indexNum, String email, String password, Role role) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.indexNum = indexNum;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getSurname(),
				user.getIndexNum(), user.getEmail(), user.getPassword(), user.getRole());
	}

	public UserDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
