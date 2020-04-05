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
@Table(name = "role")
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
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 
}
