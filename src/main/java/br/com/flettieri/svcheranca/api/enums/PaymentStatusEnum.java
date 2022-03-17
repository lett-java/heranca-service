package br.com.flettieri.svcheranca.api.enums;

import lombok.Getter;

@Getter
public enum PaymentStatusEnum {

	PAID("Paid"),
	PROCESSING("Processing"),
	CANCELLED("Cancelled");
	
	private String description;
	
	PaymentStatusEnum(String description) {
		this.description = description;
	}
	
	
}
