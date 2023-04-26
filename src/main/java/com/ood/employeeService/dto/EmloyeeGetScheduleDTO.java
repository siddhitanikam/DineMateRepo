package com.ood.employeeService.dto;

public class EmloyeeGetScheduleDTO {
	private int empId;
	private String shiftDate;
	private int scheduleId;
	private int shiftId;

	// Constructor
	public EmloyeeGetScheduleDTO(int empId, String shiftDate, int scheduleId, int shiftId) {
		this.empId = empId;
		this.shiftDate = shiftDate;
		this.scheduleId = scheduleId;
		this.shiftId = shiftId;

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

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}
}
