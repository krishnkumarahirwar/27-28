package com.capgemini.healthcaremanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	private long adminId;
	private String adminPassword;
	private String adminName;
			
	public Admin() {
	}

	public Admin(long adminId, String adminPassword, String adminName) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminName=" + adminName + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Admin admin = (Admin) o;
		return adminId == admin.adminId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminId);
	}
}
