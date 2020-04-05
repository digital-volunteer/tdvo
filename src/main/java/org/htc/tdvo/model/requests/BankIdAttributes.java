package org.htc.tdvo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankIdAttributes {

	@JsonProperty
	private String personalNumber;
	
	@JsonProperty
	private String name;

	@JsonProperty
	private String givenName;

	@JsonProperty
	private String surname;	
	
	@JsonProperty
	private String ipAddress;	
	
	@JsonProperty
	private String notBefore;
	
	@JsonProperty
	private String notAfter;	
	
	
	@JsonProperty
	private String signature;	
	
	@JsonProperty
	private String ocspResponse;

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

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
 
	
}
