package com.capgemini.healthcaremanagementsystem.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Test {
	@Id
	private long testId;
	private String testName;
	private int testPrice;
	private Long centerId;

	public Test() {

	}

	public Test(long testId, String testName, int testPrice) {
		this.testId = testId;
		this.testName = testName;
		this.testPrice = testPrice;
		
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Test test = (Test) o;
		return testId == test.testId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(testId);
	}

	
}
	