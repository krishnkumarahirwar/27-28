package com.capgemini.healthcaremanagementsystem.entity;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiagnosticCenter {
	
    private String centerName;
    
    @Id
    private long centerId;
    private BigInteger contactNumber;
    private String location;

    @ElementCollection
    private List<Test> listOfTest;
    
    @ElementCollection
    private List<Appointment>appointments;

    public DiagnosticCenter() {
    }

    public DiagnosticCenter(String centerName, long centerId, BigInteger contactNumber, String location) {
        this.centerName = centerName;
        this.centerId = centerId;
        this.contactNumber = contactNumber;
        this.location = location;
    }

    public List<Test> getListOfTest() {
        return listOfTest;
    }

    public void setListOfTest(List<Test> listOfTest) {
        this.listOfTest = listOfTest;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

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

    @Override
    public String toString() {
        return "DiagnosticCenter [centerName=" + centerName + ", centerId=" + centerId + ", contactNumber=" + contactNumber
                + ", location=" + location + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosticCenter that = (DiagnosticCenter) o;
        return centerId == that.centerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerId);
    }
}
