package com.todo.persistance.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Long id;

	@Column(name = "NAME", nullable = false, unique=true)
	private String name;

//	@Column(name = "DOB")
//	private Date dateOfBirth;
	
//	@Column(name = "DATE_OF_HIRE")
//	private Date dateOfHire;

	@Column(name = "SALARY")
	private BigDecimal salary;

	@Column(name = "MARITAL_STATUS")
	private String maritalStatus;

	@Column(name = "TITLE")
	private String title;
	
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
	

	public Employee() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}
