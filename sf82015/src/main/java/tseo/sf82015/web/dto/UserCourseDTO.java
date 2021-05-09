package tseo.sf82015.web.dto;

import java.util.Date;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.User;
import tseo.sf82015.model.UserCourse;

public class UserCourseDTO {
	
	private Long id;
	private Course course;
	private User user;
	private Date dateAdded;
	
	public UserCourseDTO() {
		
	}
	
	public UserCourseDTO(UserCourse userCourse) {
		
		id = userCourse.getId();
		course = userCourse.getCourse();
		user = userCourse.getUser();
		dateAdded = userCourse.getDateAdded();
		
		
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
	
	

}
