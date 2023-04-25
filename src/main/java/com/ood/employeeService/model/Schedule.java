package com.ood.employeeService.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Schedule")
public class Schedule {

	@Id
	@Column(name = "ScheduleId")
	private int scheduleId;

	@ManyToOne
	@JoinColumn(name = "EmployeeId", referencedColumnName = "EmpId")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "ShiftId", referencedColumnName = "ShiftId")
	private Shift shift;

	@Column(name = "ShiftDate")
	private Date shiftDate;

	@ManyToOne
	@JoinColumn(name = "TaskId", referencedColumnName = "TaskId")
	private Task task;

	@ManyToOne
	@JoinColumn(name = "StatusId", referencedColumnName = "StatusId")
	private Status status;

	// getters and setters

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Date getDate() {
		return shiftDate;
	}

	public void setDate(Date shiftDate) {
		this.shiftDate = shiftDate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
