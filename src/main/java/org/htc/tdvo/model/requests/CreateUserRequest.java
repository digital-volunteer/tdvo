package org.htc.tdvo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

	@JsonProperty
	private String personalNumber;

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
 
	 
	 
}
