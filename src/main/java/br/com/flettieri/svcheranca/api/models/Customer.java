package br.com.flettieri.svcheranca.api.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends EntityBase {

	@Column
	private String name;
	
	@Column
	private boolean enabled; 
	
	@Column
	private LocalDateTime disabledAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Payment> payments;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "wallet_id", referencedColumnName = "id")
	private Wallet wallet;

	public void disable() {
		this.disabledAt = LocalDateTime.now();
		this.enabled = false; 
	}
	
	public void enable() {
		this.disabledAt = null;
		this.enabled = true; 
	}

}
