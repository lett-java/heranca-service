package br.com.flettieri.svcheranca.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flettieri.svcheranca.api.models.Customer;
import br.com.flettieri.svcheranca.api.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<Customer> save(@RequestBody Customer customer) throws Exception {
		return ResponseEntity.ok().body(customerService.save(customer));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) throws Exception {
		return ResponseEntity.ok().body(customerService.update(id, customer.getName()));
	}	
	
	@PutMapping("/disable/{id}")
	public ResponseEntity<Customer> updateDisable(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(customerService.disable(id));
	}	
	
	@PutMapping("/enable/{id}")
	public ResponseEntity<Customer> updateEnable(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(customerService.enable(id));
	}	
}
