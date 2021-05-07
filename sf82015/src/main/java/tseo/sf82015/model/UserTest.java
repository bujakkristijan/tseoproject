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
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.REFRESH)
	private Test test;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.REFRESH)
	private User user;

	@Column(nullable = true)
	private int grade;
	
	@Column(nullable = true)
	private Date dateCreated;
	
	@Column(nullable = true)
	private String note;
	
	public UserTest() {
		super();
	}

	public UserTest(Test test, User user, int grade, Date dateCreated, String note) {
		super();
		
		this.test = test;
		this.user = user;
		this.grade = grade;
		this.dateCreated = dateCreated;
		this.note = note;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
