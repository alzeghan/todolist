package com.todo.persistance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity(name="TBL_TASK")
public class Task implements Serializable {

    @Id
    @Generated(GenerationTime.INSERT)
    private long id;

    @Column(columnDefinition="TEXT")
    private String description;

    private boolean status;
    private boolean active;
    
    
    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Employee assignedTo;

    @Enumerated(value = EnumType.ORDINAL)
    private TaskPriority priority;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Task() {
    	this.priority = TaskPriority.LOW;
    }

    public Task(long userId, String title, boolean status, TaskPriority priority, Date dueDate, Employee employee) {
    	this.assignedTo = employee;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Employee getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employee assignedTo) {
		this.assignedTo = assignedTo;
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
