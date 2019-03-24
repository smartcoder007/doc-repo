package com.angular.test;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resident implements Serializable {	
	private static final long serialVersionUID = -7825656692349250997L;
	private String residentId;
	private String residentName;
	private String residentContactNumber;
	public String getResidentId() {
		return residentId;
	}
	public void setResidentId(String residentId) {
		this.residentId = residentId;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getResidentContactNumber() {
		return residentContactNumber;
	}
	public void setResidentContactNumber(String residentContactNumber) {
		this.residentContactNumber = residentContactNumber;
	}
	

}
