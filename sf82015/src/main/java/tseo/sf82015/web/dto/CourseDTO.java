package tseo.sf82015.web.dto;

import tseo.sf82015.model.Course;

public class CourseDTO {
	

	private Long id;
	private String name;
	private String code;
	private double price;
	private String description;
	
	public CourseDTO() {
		
	}

	public CourseDTO(Long id, String name, String code, double price, String description) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.description = description;
	}
	
	public CourseDTO(Course course) {
		this(course.getId(), course.getName(), course.getCode(), course.getPrice(), course.getDescription());
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
