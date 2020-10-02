package com.capgemini.healthcaremanagementsystem.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long customerId;
	private String customerPassword;
	private String customerName;
	private BigInteger customerPhoneNumber;
	private String customerEmail;
	private String gender;
	private int customerAge;
    @ElementCollection
	private List<Appointment> listOfAppointments = new ArrayList<Appointment>();

	public Customer() {
		super();
	}

	public Customer(long customerId, String customerPassword, String customerName, BigInteger customerPhoneNumber,
			String customerEmail, String gender, int customerAge) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.gender = gender;
		this.customerAge = customerAge;
	}

	public Customer(String customerPassword, String customerName, BigInteger customerPhoneNumber, String customerEmail,
			String gender, int customerAge) {
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.gender = gender;
		this.customerAge = customerAge;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigInteger getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(BigInteger customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public List<Appointment> getListOfAppointments() {
		return listOfAppointments;
	}

	public void setListOfAppointments(List<Appointment> listOfAppointments) {
		this.listOfAppointments = listOfAppointments;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerPhoneNumber=" + customerPhoneNumber + ", customerEmail=" + customerEmail
				+ ", gender=" + gender + ", customerAge=" + customerAge + ", listOfAppointments=" + listOfAppointments
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return customerId == customer.customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}
}