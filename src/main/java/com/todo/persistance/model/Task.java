package com.todo.persistance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_TASK")
public class Task implements Serializable {

    @Id
    @Generated(GenerationTime.INSERT)
    private Long id;

    @Column(columnDefinition="TEXT")
    private String description;

    private Boolean status;
    private Boolean active;
    
    @OneToOne
    @JoinColumn(name = "EMPLOYEE_ID") 
    private Employee employee;
    
    @OneToOne
    @JoinColumn(name = "id") 
    private Building building;


    @Enumerated(value = EnumType.ORDINAL)
    private TaskPriority priority;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Task() {
    	this.priority = TaskPriority.LOW;
    }

    public Task(Long userId, String title, boolean status, TaskPriority priority, Date dueDate, Employee employee) {
    	this.employee = employee;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    @Id @GeneratedValue(generator="foreign")
    @GenericGenerator(name="foreign", strategy = "increment")
    public Long getId() {
        return id;
    }

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee assignedTo) {
		this.employee = assignedTo;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
