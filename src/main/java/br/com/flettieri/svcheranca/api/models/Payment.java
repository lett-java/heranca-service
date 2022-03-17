package br.com.flettieri.svcheranca.api.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.flettieri.svcheranca.api.enums.PaymentStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorColumn(name = "payment_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "payment")
public class Payment extends EntityBase {

	@Enumerated(EnumType.STRING)
	private PaymentStatusEnum paymentStatus;
	
	@Column
	private BigDecimal amount;
	
	@Column
	private LocalDate paymentDate;
	
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
}
