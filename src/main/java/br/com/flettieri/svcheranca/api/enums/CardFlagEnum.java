package br.com.flettieri.svcheranca.api.enums;

import lombok.Getter;

@Getter
public enum CardFlagEnum {

	VISA("Visa"),
	MASTER_CARD("Master Card"),
	ALELO("Alelo"),
	AMERICA_EXPRESS("American Express"),
	HIPERCARD("Hipercard");
	
	private String description;

	CardFlagEnum(String description) {
		this.description = description;
	}
}
