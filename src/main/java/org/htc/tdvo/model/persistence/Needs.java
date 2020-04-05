package org.htc.tdvo.model.persistence;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "needs")
public class Needs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	@Column
	private Long id;
	
	@Column(nullable = false, unique = true)
	@JsonProperty
	private String personalNumber;
	
	@Column(nullable = false)
	@JsonProperty
	private Timestamp entryCreated;
	 

	@Column(nullable = false)
	@JsonProperty
	private Timestamp timeSlot;
	
	
	@Column(nullable = false)
	@JsonProperty
	private String description;
	 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public Timestamp getEntryCreated() {
		return entryCreated;
	}

	public void setEntryCreated(Timestamp entryCreated) {
		this.entryCreated = entryCreated;
	}

	public Timestamp getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(Timestamp timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

 
}
