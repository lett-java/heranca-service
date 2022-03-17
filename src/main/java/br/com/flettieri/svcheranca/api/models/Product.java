package br.com.flettieri.svcheranca.api.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.flettieri.svcheranca.api.enums.ProductTypeEnum;
import br.com.flettieri.svcheranca.api.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends EntityBase {
	
	@Column
	private String name;
	
	@Column
	private Integer quantity;
	
	@Column(name = "product_value")
	private BigDecimal productValue;
	
	@Enumerated(EnumType.STRING)
	private ProductTypeEnum productType;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

}
