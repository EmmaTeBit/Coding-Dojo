package com.em.travel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="travels")
public class Travel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	@Size(min=1, max=255, message="Expense Name must not be empty")
	private String expense;
	
	@NotNull
	@Size(min=1, max=255, message="Vendor Name must not be empty")
	private String vendor;
	
	@NotNull(message="Amount must not be blank")
	@Min(value=0, message="Amount must be greater than zero")
	private Double amount;

	
	@NotNull
	@Size(min=1,max=255,message="Description must not be empty")
	private String description;
	
	public Travel() {
	}
	//GETTERS and SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
