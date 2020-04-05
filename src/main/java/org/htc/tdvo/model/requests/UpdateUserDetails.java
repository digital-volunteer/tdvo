package org.htc.tdvo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserDetails {

	@JsonProperty
	private String sessionId;
	
	
	@JsonProperty
	private boolean carAndCanDrive;
	
	@JsonProperty
	private boolean stuffAndLeave;
	
	@JsonProperty
	private boolean canDoShopping;
	
	@JsonProperty
	private boolean travelByBicycle;
	
	@JsonProperty
	private boolean artist;
	
	@JsonProperty
	private boolean aceptConditions;
	

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isCarAndCanDrive() {
		return carAndCanDrive;
	}

	public void setCarAndCanDrive(boolean carAndCanDrive) {
		this.carAndCanDrive = carAndCanDrive;
	}

	public boolean isStuffAndLeave() {
		return stuffAndLeave;
	}

	public void setStuffAndLeave(boolean stuffAndLeave) {
		this.stuffAndLeave = stuffAndLeave;
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
 
	 
	 
}
