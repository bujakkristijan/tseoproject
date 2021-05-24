package tseo.sf82015.web.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.Test;
import tseo.sf82015.model.User;

public class TestDTO {
	
	private Long id;
	private String title;
	private String description;
	private Date dateCreated;
	private int maxPoints;
    private Course course;
    private User user;
    
    public TestDTO() {
    	
    }
    
    public TestDTO(Test test) {
    	id = test.getId();
    	title = test.getTitle();
    	description = test.getDescription();
    	dateCreated = test.getDateCreated();
    	maxPoints = test.getMaxPoints();
    	//course = new CourseDTO(test.getCourse());
    	course = test.getCourse();
    	user = test.getUser();
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
    

}
