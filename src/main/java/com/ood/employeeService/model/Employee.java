package com.ood.employeeService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "EmpId")
	private int empId;

	@Column(name = "SUId")
	private long suId;

	@Column(name = "FName")
	private String fName;

	@Column(name = "LName")
	private String lName;

	@Column(name = "EmailId")
	private String emailId;

	@Column(name = "PhoneNo")
	private String phoneNo;

	@Column(name = "DWPoints")
	private int dwPoints;

	@ManyToOne
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	private Role role;

	// getters and setters

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fName;
	}

	public void setFname(String fName) {
		this.fName = fName;
	}

	public String getLname() {
		return lName;
	}

	public void setLname(String lName) {
		this.lName = lName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getSuId() {
		return suId;
	}

	public void setSuId(long suId) {
		this.suId = suId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getDwpoints() {
		return dwPoints;
	}

	public void setDwpoints(int dwPoints) {
		this.dwPoints = dwPoints;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
