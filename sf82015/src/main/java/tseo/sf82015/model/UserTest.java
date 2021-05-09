package tseo.sf82015.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class UserTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private Test test;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private User userStudentSignedUp;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private User userProfessorUpdate;

	@Column(nullable = true)
	private int points;
	
	@Column(nullable = true)
	private Date dateCreated;
	
	@Column(nullable = true)
	private Date dateUpdated;
	
	@Column(nullable = true)
	private String status;
	
	@Column(nullable = true)
	private String note;
	
	public UserTest() {
		
	}

	public UserTest(Test test, User userStudentSignedUp, User userProfessorUpdate,  int points, Date dateCreated, Date dateUpdated, String status, String note) {
		
		this.test = test;
		this.userStudentSignedUp = userStudentSignedUp;
		this.userProfessorUpdate = userProfessorUpdate;
		this.points = points;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.status = status;
		this.note = note;
	}

	public User getUserProfessorUpdate() {
		return userProfessorUpdate;
	}

	public void setUserProfessorUpdate(User userProfessorUpdate) {
		this.userProfessorUpdate = userProfessorUpdate;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpadted(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
