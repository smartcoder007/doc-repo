package com.angular.test;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Home implements Serializable {

	private static final long serialVersionUID = 1494367594846223796L;

	@Id
	private String id;
	private String buildingType;
	private String occupiedStatus;
	private String activeState;
	private Address address;
	private List<Resident> residentList;	
	private List<Caregiver> caregivers;
	
	
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
	
	public List<Resident> getResidentList() {
		return residentList;
	}
	public void setResidentList(List<Resident> residentList) {
		this.residentList = residentList;
	}
	public List<Caregiver> getCaregivers() {
		return caregivers;
	}
	public void setCaregivers(List<Caregiver> caregivers) {
		this.caregivers = caregivers;
	}
	
	@Override
	public String toString() {
		return "Home [id=" + id + ", buildingType=" + buildingType
				+ ", occupiedStatus=" + occupiedStatus + ", activeState="
				+ activeState + ", address=" + address + ", residentList="
				+ residentList + ", caregivers=" + caregivers + "]";
	}
	
	
	

}
