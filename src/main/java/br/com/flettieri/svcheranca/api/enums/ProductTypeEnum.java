package br.com.flettieri.svcheranca.api.enums;

import lombok.Getter;

@Getter
public enum ProductTypeEnum {

	CELL_PHONE("Cell phone"),
	COMPUTING("Computing"),
	TV_AND_VIDEO("TV and Video"),
	HOME_APPLIANCES("Home appliances");
	
	private String description;
	
	ProductTypeEnum(String description) {
		this.description = description;
	}
	
}
