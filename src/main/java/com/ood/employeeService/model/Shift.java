package com.ood.employeeService.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Shift")
public class Shift {

	@Id
	@Column(name = "ShiftId")
	private int shiftId;

	@Column(name = "StartTime")
	private Time startTime;

	@Column(name = "EndTime")
	private Time endTime;

	@Column(name = "Day")
	private String day;

	@ManyToOne
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", referencedColumnName = "EmpId")
	private Employee employee;

	// getters and setters

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
