package br.com.flettieri.svcheranca.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.flettieri.svcheranca.api.models.Customer;
import br.com.flettieri.svcheranca.api.models.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

	Wallet findByCustomer(Customer customer);

}
