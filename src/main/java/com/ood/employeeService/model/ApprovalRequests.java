package com.ood.employeeService.model;

public class ApprovalRequests {
	private int requestId;
	private Employee assignee;
//	private StudentSupervisor supId;
	private String status;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Employee getAssignee() {
		return assignee;
	}

	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}

	/*
	 * public StudentSupervisor getSupId() { return supId; }
	 * 
	 * public void setSupId(StudentSupervisor supId) { this.supId = supId; }
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
