package tseo.sf82015.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.Course;
import tseo.sf82015.model.Payment;

@Service
@Transactional
public interface PaymentService {
	
	Payment findOne(Long id);
	List<Payment> findAll();
	
	Payment save(Payment payment);
	Payment delete(Payment payment);

}
