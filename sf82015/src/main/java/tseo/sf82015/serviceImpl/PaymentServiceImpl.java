package tseo.sf82015.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tseo.sf82015.model.Payment;
import tseo.sf82015.repository.PaymentRepository;
import tseo.sf82015.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public Payment findOne(Long id) {
		return paymentRepository.findById(id).get();
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

}
