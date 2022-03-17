package br.com.flettieri.svcheranca.api.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flettieri.svcheranca.api.enums.PaymentStatusEnum;
import br.com.flettieri.svcheranca.api.models.Customer;
import br.com.flettieri.svcheranca.api.models.Payment;
import br.com.flettieri.svcheranca.api.models.PaymentBillet;
import br.com.flettieri.svcheranca.api.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private CustomerService customerService;
	
	public Payment save(Payment payment) throws Exception {
		Customer customer = customerService.findById(payment.getCustomer().getId());
		payment.setCustomer(customer);
		
		if (payment.getClass().equals(PaymentBillet.class)) {
			payment.setPaymentStatus(PaymentStatusEnum.PROCESSING);
		} else {
			payment.setPaymentStatus(PaymentStatusEnum.PAID);
			payment.setPaymentDate(LocalDate.now());
	
			insertBalanceInWallet(payment);
		}
		
		return paymentRepository.save(payment);
	}
	
	private void insertBalanceInWallet(Payment payment) {
		walletService.insertBalance(payment.getCustomer().getWallet(), payment.getAmount());
	}
	
}
