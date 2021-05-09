package tseo.sf82015.web.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.Payment;
import tseo.sf82015.model.User;

public class PaymentDTO {
	
	private Long id;
	private Course course;
	private User user;
	private Date datePayed;
	private double amount;
	private int cardNumber;
	private int recipientNumber;
	
	
	public PaymentDTO() {
		
	}
	
	public PaymentDTO(Payment payment) {
		
    	id = payment.getId();
    	course = payment.getCourse();
    	user = payment.getUser();
    	datePayed = payment.getDatePayed();
    	amount = payment.getAmount();
    	cardNumber = payment.getCardNumber();
    	recipientNumber = payment.getRecipientNumber();
    	
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
