package br.com.flettieri.svcheranca.api.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
	
	ACTIVE("Active"),
	INACTIVE("Inactive"),
	BLOCKED("Blocked");
	
	private String description;
	
	StatusEnum(String description) {
		this.description = description;
	}

}
