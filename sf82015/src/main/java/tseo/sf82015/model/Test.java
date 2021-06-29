package tseo.sf82015.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Test implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) 
	private String title;
	
	@Column(nullable = false) 
	private String description;
	
	@Column(nullable = true)
	private Date dateCreated;
	
	@Column(nullable = false) 
	private int maxPoints;
	
	@ManyToOne
    private Course course;
	
	@ManyToOne
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonBackReference
	@OneToMany(mappedBy = "test", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<UserTest> userTests= new ArrayList<UserTest>();
	
	public Test() {}
	
	public Test(Long id, String title, String description, Date dateCreated, int maxPoints, Course course, User user, List<UserTest> userTests) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
		this.maxPoints = maxPoints;
		this.course = course;
		this.user = user;
		this.userTests = userTests;
	}


	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<UserTest> getUserTests() {
		return userTests;
	}

	public void setUserTests(List<UserTest> userTests) {
		this.userTests = userTests;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	
}
