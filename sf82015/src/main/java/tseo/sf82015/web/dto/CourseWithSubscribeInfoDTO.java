package tseo.sf82015.web.dto;

import tseo.sf82015.model.Course;

public class CourseWithSubscribeInfoDTO {
	
	private Course course;
	
	private boolean subscribedInfo;
	
	public CourseWithSubscribeInfoDTO() {
		
	}

	public CourseWithSubscribeInfoDTO(Course course, boolean subscribedInfo) {
		super();
		this.course = course;
		this.subscribedInfo = subscribedInfo;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public boolean isSubscribedInfo() {
		return subscribedInfo;
	}

	public void setSubscribedInfo(boolean subscribedInfo) {
		this.subscribedInfo = subscribedInfo;
	}

}
