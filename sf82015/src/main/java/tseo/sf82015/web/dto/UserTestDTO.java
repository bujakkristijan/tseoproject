package tseo.sf82015.web.dto;

import java.util.Date;

import tseo.sf82015.model.Test;
import tseo.sf82015.model.User;
import tseo.sf82015.model.UserTest;

public class UserTestDTO {
	
	private Long id;
	private Test test;
	private User userStudentSignedUp;
	private User userProfessorUpdate;
	private int points;
	private Date dateCreated;
	private Date dateUpdated;
	private String status;
	private String note;
	private String signedUpStatus;
	
	public UserTestDTO() {
		
	}
	
	public UserTestDTO(UserTest userTest) {
		
		id = userTest.getId();
		test = userTest.getTest();
		userStudentSignedUp = userTest.getUserStudentSignedUp();
		userProfessorUpdate = userTest.getUserProfessorUpdate();
		points = userTest.getPoints();
		dateCreated = userTest.getDateCreated();
		dateUpdated = userTest.getDateUpdated();
		status = userTest.getStatus();
		note = userTest.getNote();
		signedUpStatus = userTest.getSignedUpStatus();
		
	}

	public String getSignedUpStatus() {
		return signedUpStatus;
	}

	public void setSignedUpStatus(String signedUpStatus) {
		this.signedUpStatus = signedUpStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	

	public User getUserStudentSignedUp() {
		return userStudentSignedUp;
	}

	public void setUserStudentSignedUp(User userStudentSignedUp) {
		this.userStudentSignedUp = userStudentSignedUp;
	}

	public User getUserProfessorUpdate() {
		return userProfessorUpdate;
	}

	public void setUserProfessorUpdate(User userProfessorUpdate) {
		this.userProfessorUpdate = userProfessorUpdate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	

}
