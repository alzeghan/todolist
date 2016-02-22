package com.todo.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_BUILDING")
public class Building implements Serializable {

	@Column(name = "ID")
	@GeneratedValue
	@Id
	private Long id;

	@Column(name = "NAME", nullable = false, unique=true)
	private String name;

	// TODO: need to add the City, region, this is just for demo purpose
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "ACTIVE")
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
