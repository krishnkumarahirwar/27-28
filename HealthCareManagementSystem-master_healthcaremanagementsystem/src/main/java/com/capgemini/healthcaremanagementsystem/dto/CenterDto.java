package com.capgemini.healthcaremanagementsystem.dto;

import java.math.BigInteger;

import javax.persistence.Id;

public class CenterDto {
	
	private String centerName;
    private long centerId;
    private BigInteger contactNumber;
    private String location;
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public long getCenterId() {
		return centerId;
	}
	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}
	public BigInteger getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    
    

}
