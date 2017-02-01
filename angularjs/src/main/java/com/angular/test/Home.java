package com.angular.test;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Home implements Serializable {

	private static final long serialVersionUID = 1494367594846223796L;

	@Id
	private String id;
	private String buildingType;
	private String occupiedStatus;
	private String activeState;
	private Address address;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public String getOccupiedStatus() {
		return occupiedStatus;
	}
	public void setOccupiedStatus(String occupiedStatus) {
		this.occupiedStatus = occupiedStatus;
	}
	public String getActiveState() {
		return activeState;
	}
	public void setActiveState(String activeState) {
		this.activeState = activeState;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", buildingType=" + buildingType
				+ ", occupiedStatus=" + occupiedStatus + ", activeState="
				+ activeState + ", address=" + address + "]";
	}
	
	

}
