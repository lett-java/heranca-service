package br.com.flettieri.svcheranca.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.flettieri.svcheranca.api.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
