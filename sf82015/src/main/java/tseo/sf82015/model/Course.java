package tseo.sf82015.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Course implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) 
	private String name;
	
	@Column(nullable = false) 
	private String code;
	
	@Column(nullable = false) 
	private double price;
	
	@Column(nullable = false) 
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="id", cascade = CascadeType.REMOVE)
    private List<Test> tests;
	
	@JsonIgnore
	@OneToMany(mappedBy="id", cascade = CascadeType.REMOVE)
    private List<UserCourse> userCourses;
	
	@JsonIgnore
	@OneToMany(mappedBy="id", cascade = CascadeType.REMOVE)
    private List<Payment> payments;
	
	public Course() {}
	
	public Course(String name, String code, double price, String description, List<UserCourse> userCourses, List<Test> tests,
			List<Payment> payments) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.description = description;
		this.userCourses = userCourses;
		this.tests = tests;
		this.payments = payments;
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

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public List<UserCourse> getUserCourses() {
		return userCourses;
	}

	public void setUserCourse(List<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	

}
