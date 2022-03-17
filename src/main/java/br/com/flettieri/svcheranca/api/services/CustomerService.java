package br.com.flettieri.svcheranca.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flettieri.svcheranca.api.models.Customer;
import br.com.flettieri.svcheranca.api.models.Wallet;
import br.com.flettieri.svcheranca.api.repositories.CustomerRepository;
import br.com.flettieri.svcheranca.api.validations.CustomerValidator;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerValidator customerValidator; 
	
	@Autowired
	private WalletService walletService;

	public Customer save(Customer customer) throws Exception {
		customer.setWallet(walletService.save(new Wallet()));
		customerValidator.validateName(customer.getName());
		customer.setEnabled(true);
		
		return customerRepository.save(customer);
	}
	
	
	public Customer update(Long id, String name) throws Exception {
		customerValidator.validateName(name);
		Customer customer = findById(id);
		customer.setName(name);
		
		return customerRepository.save(customer);
	}
	
	public Customer disable(Long id) throws Exception {
		Customer customer = findById(id);
		customerValidator.validateEnableEqualsTrue(customer.isEnabled());
		customer.disable();

		return customerRepository.save(customer);
	}
	
	public Customer enable(Long id) throws Exception {
		Customer customer = findById(id);
		customerValidator.validateEnableEqualsFalse(customer.isEnabled());
		customer.enable();

		return customerRepository.save(customer);
	}

	public Customer findById(Long id) throws Exception {
		return customerRepository.findById(id)
				.orElseThrow(() -> new Exception("Customer not found"));
	}
}
