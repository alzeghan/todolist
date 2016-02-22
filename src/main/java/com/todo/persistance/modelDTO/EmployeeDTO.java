package com.todo.persistance.modelDTO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDTO implements Serializable {

	private Long id;

	@NotNull(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 2, message = "{javax.validation.constraints.Size.message}")
	private String name;

	@NotNull(message = "{javax.validation.constraints.NotNull.message}")
	private BigDecimal salary;

	private String maritalStatus;

	@NotNull(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 2, message = "{javax.validation.constraints.Size.message}")
	private String title;
	
	private Boolean active;

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
