package br.com.flettieri.svcheranca.api.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.flettieri.svcheranca.api.enums.CardFlagEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "PaymentCard")
public class PaymentCard extends Payment {
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Enumerated(EnumType.STRING)
	private CardFlagEnum cardFlag;
	
}
