package com.ood.employeeService.dto;

public class TaskAssignmentDTO {

	private int scheduleId;
	private int taskId;
	private int statusId;

	public TaskAssignmentDTO(int scheduleId, int taskId, int statusId) {
		super();
		this.scheduleId = scheduleId;
		this.taskId = taskId;
		this.statusId = statusId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}