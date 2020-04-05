package org.htc.tdvo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankIdResponse {

	@JsonProperty
	private String sessionId;
	
	@JsonProperty
	private String username;
	
	@JsonProperty
	private BankIdAttributes userAttributes;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BankIdAttributes getUserAttributes() {
		return userAttributes;
	}

	public void setUserAttributes(BankIdAttributes userAttributes) {
		this.userAttributes = userAttributes;
	}
	
	
}
