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
public class UserCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private User user;

	@Column(nullable = true)
	private Date dateAdded;
	
	public UserCourse() {
		super();
	}
	
	public UserCourse(Long id, Course course, User user, Date dateAdded) {
		super();
		this.id = id;
		this.course = course;
		this.user = user;
		this.dateAdded = dateAdded;

	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "UserCourse [id=" + id + ", course=" + course + ", user=" + user + ", dateAdded=" + dateAdded + "]";
	}

	

	
	
	
}
