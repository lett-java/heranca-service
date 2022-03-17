package br.com.flettieri.svcheranca.api.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "wallet")
public class Wallet extends EntityBase {
	
	@Column
	private String uuid;
	
	@JsonIgnore
	@OneToOne(mappedBy = "wallet")
	private Customer customer;

	@Column(columnDefinition = "integer default 0")
	private BigDecimal balance;
	
	@Column(columnDefinition = "integer default 0")
	private BigDecimal balanceUsed;

}
