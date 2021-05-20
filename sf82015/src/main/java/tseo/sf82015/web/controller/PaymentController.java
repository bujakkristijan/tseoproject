package tseo.sf82015.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import tseo.sf82015.model.Course;
import tseo.sf82015.model.Payment;
import tseo.sf82015.model.User;
import tseo.sf82015.service.CourseService;
import tseo.sf82015.service.PaymentService;
import tseo.sf82015.service.UserService;
import tseo.sf82015.web.dto.CourseDTO;
import tseo.sf82015.web.dto.PaymentDTO;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "payment")
public class PaymentController {
	
	@Autowired 
	PaymentService paymentService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id) {
		if (paymentService.findOne(id) == null) {
			return new ResponseEntity<PaymentDTO>(HttpStatus.NOT_FOUND);
		}	
		Payment payment = paymentService.findOne(id);
	
		return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPayments", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> getPayments() {
		List<Payment> payments = paymentService.findAll();

		if (payments.equals(null))
			return new ResponseEntity<List<PaymentDTO>>(HttpStatus.NOT_FOUND);
		
		List<PaymentDTO> paymentsDTO = new ArrayList<>();
		for (Payment p : payments) {
			paymentsDTO.add(new PaymentDTO(p));
		}
		return new ResponseEntity<List<PaymentDTO>>(paymentsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addPayment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO) {
		if(paymentDTO == null) {
			return new ResponseEntity<PaymentDTO>(HttpStatus.BAD_REQUEST);
		}
		Payment payment = new Payment();
		
		payment.setCourse(paymentDTO.getCourse());
		payment.setUser(paymentDTO.getUser()); 
		payment.setDatePayed(paymentDTO.getDatePayed());
		payment.setAmount(paymentDTO.getAmount());
		payment.setCardNumber(paymentDTO.getCardNumber());
		payment.setRecipientNumber(paymentDTO.getRecipientNumber());
		
		payment = paymentService.save(payment);
		
		if (payment != null) {
			return new ResponseEntity<PaymentDTO>(new PaymentDTO(payment), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<PaymentDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PaymentDTO> delete(@PathVariable Long id) {		
		Payment payment = paymentService.findOne(id);
		
		if(payment == null)
			return new ResponseEntity<PaymentDTO>(HttpStatus.NOT_FOUND);
									
		paymentService.delete(payment);
		return new ResponseEntity<PaymentDTO>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getMyPayments", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentDTO>> getMyPayments() {
		List<Payment> payments = paymentService.findAll();
		
		if (payments.isEmpty()) 
			return new ResponseEntity<List<PaymentDTO>>(HttpStatus.NOT_FOUND);			
		
		//User user = userService.getCurrentUser();
		User user = userService.getLoggedUser();
		List<Payment> myPayments = new  ArrayList<Payment>();
	
		if(user.getRole().equals("STUDENT")) 
			for(Payment p : payments)
				if(p.getUser().getId() == user.getId()) {
					myPayments.add(p);
				}
		
		List<PaymentDTO> myPaymentsDTO = new ArrayList<PaymentDTO>();
		for (Payment p : payments) {
			myPaymentsDTO.add(new PaymentDTO(p));
		}
		return new ResponseEntity<List<PaymentDTO>>(myPaymentsDTO, HttpStatus.OK);
		
	}

}