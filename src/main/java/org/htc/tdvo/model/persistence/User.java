package org.htc.tdvo.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private long id;

	@Column(nullable = false, unique = true)
	@JsonProperty
	private String personalNumber;

	@Column(nullable = false)
	@JsonProperty
	private String sessionId;

	@Column(nullable = true)
	@JsonProperty
	private String name;

	@Column(nullable = true)
	@JsonProperty
	private String givenName;

	@Column(nullable = true)
	@JsonProperty
	private String surname;

//	@Column(nullable = false)
//	@JsonProperty
//	private String ipAddress;
//	 
//
//	@Column(nullable = true)
//	@JsonProperty
//	private String notBefore;
//
//	@Column(nullable = true)
//	@JsonProperty
//	private String notAfter;
//
//	@Column(nullable = true)
//	@JsonProperty
//	private String signature;
//
//	@Column(nullable = true)
//	@JsonProperty
//	private String ocspResponse;
	
	
	@Column(nullable = true)
	@JsonProperty
	private String phoneNumber;
	
	@Column(nullable = true)
	@JsonProperty
	private String email;	
	
	@Column(nullable = true)
	@JsonProperty
	private boolean carAndCanDrive;
	
	@Column(nullable = true)
	@JsonProperty
	private boolean stuffAndLeave;
	
	@Column(nullable = true)
	@JsonProperty
	private boolean canDoShopping;
	
	@Column(nullable = true)
	@JsonProperty
	private boolean travelByBicycle;
	
	@Column(nullable = true)
	@JsonProperty
	private boolean artist;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isCarAndCanDrive() {
		return carAndCanDrive;
	}

	public void setCarAndCanDrive(boolean carAndCanDrive) {
		this.carAndCanDrive = carAndCanDrive;
	}
 
	public boolean isCanDoShopping() {
		return canDoShopping;
	}

	public void setCanDoShopping(boolean canDoShopping) {
		this.canDoShopping = canDoShopping;
	}

	public boolean isTravelByBicycle() {
		return travelByBicycle;
	}

	public void setTravelByBicycle(boolean travelByBicycle) {
		this.travelByBicycle = travelByBicycle;
	}

	public boolean isArtist() {
		return artist;
	}

	public void setArtist(boolean artist) {
		this.artist = artist;
	}

	public boolean isAceptConditions() {
		return aceptConditions;
	}

	public void setAceptConditions(boolean aceptConditions) {
		this.aceptConditions = aceptConditions;
	}

	@JsonProperty
	private boolean aceptConditions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	 
 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isStuffAndLeave() {
		return stuffAndLeave;
	}

	public void setStuffAndLeave(boolean stuffAndLeave) {
		this.stuffAndLeave = stuffAndLeave;
	} 

}
