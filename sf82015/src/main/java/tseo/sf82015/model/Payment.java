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
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	private User user;
	
	@Column(nullable = true)
	private Date datePayed;
	
	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false)
	private int cardNumber;
	
	@Column(nullable = false)
	private int recipientNumber;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Payment(Long id, Course course, User user, Date datePayed, double amount, int cardNumber,
			int recipientNumber) {
		super();
		this.id = id;
		this.course = course;
		this.user = user;
		this.datePayed = datePayed;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.recipientNumber = recipientNumber;
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

	public Date getDatePayed() {
		return datePayed;
	}

	public void setDatePayed(Date datePayed) {
		this.datePayed = datePayed;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getRecipientNumber() {
		return recipientNumber;
	}

	public void setRecipientNumber(int recipientNumber) {
		this.recipientNumber = recipientNumber;
	}

	

	

}
