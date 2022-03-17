package br.com.flettieri.svcheranca.api.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "PaymentBillet")
public class PaymentBillet extends Payment {
	
	@Column(name = "bar_code")
	private String barCode;
	
}
