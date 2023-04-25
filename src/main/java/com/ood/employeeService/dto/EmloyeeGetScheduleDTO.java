package com.ood.employeeService.dto;

public class EmloyeeGetScheduleDTO {
	private int empId;
	private String shiftDate;

	// Constructor
	public EmloyeeGetScheduleDTO(int empId, String shiftDate) {
		this.empId = empId;
		this.shiftDate = shiftDate;
	}

	// Getters and Setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(String shiftDate) {
		this.shiftDate = shiftDate;
	}
}
