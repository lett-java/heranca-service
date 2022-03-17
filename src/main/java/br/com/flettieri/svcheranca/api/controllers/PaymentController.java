package br.com.flettieri.svcheranca.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flettieri.svcheranca.api.models.Payment;
import br.com.flettieri.svcheranca.api.models.PaymentBillet;
import br.com.flettieri.svcheranca.api.models.PaymentCard;
import br.com.flettieri.svcheranca.api.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/card")
	public ResponseEntity<Payment> savePaymentCard(@RequestBody PaymentCard payment) throws Exception {
		return ResponseEntity.ok().body(paymentService.save(payment));
	}
	
	@PostMapping("/billet")
	public ResponseEntity<Payment> savePaymentBillet(@RequestBody PaymentBillet payment) throws Exception {
		return ResponseEntity.ok().body(paymentService.save(payment));
	}
	
	
}
