package org.htc.tdvo.model.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


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
	  
	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	@Column(nullable = false )
	@JsonProperty
	private String name;
	
	@Column(nullable = false )
	@JsonProperty
	private String givenName;
	
	@Column(nullable = false )
	@JsonProperty
	private String surname;

	@Column(nullable = false )
	@JsonProperty
	private String ipAddress;

	@Column(nullable = true )
	@JsonProperty
	private String notBefore;
	
	@Column(nullable = true )
	@JsonProperty
	private String notAfter;

	@Column(nullable = true )
	@JsonProperty
	private String signature;
	

	@Column(nullable = true )
	@JsonProperty
	private String ocspResponse;
		 
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getNotBefore() {
		return notBefore;
	}

	public void setNotBefore(String notBefore) {
		this.notBefore = notBefore;
	}

	public String getNotAfter() {
		return notAfter;
	}

	public void setNotAfter(String notAfter) {
		this.notAfter = notAfter;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getOcspResponse() {
		return ocspResponse;
	}

	public void setOcspResponse(String ocspResponse) {
		this.ocspResponse = ocspResponse;
	}

//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_id", referencedColumnName = "id")
//	@JsonIgnore
//    private Role role;
//	
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

 
	
	
}
