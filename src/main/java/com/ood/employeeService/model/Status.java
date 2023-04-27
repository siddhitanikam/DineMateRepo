package com.ood.employeeService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Status")
public class Status {

	@Id
	@Column(name = "StatusId")
	private int statusId;

	@Column(name = "Status")
	private String status;

	@Column(name = "DWPoints")
	private int DWpoints;

	public Status(int statusId, String status, int dWpoints) {
		super();
		this.statusId = statusId;
		this.status = status;
		DWpoints = dWpoints;
    }

	public Status() {
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDWpoints() {
		return DWpoints;
	}

	public void setDWpoints(int dWpoints) {
		DWpoints = dWpoints;
	}

}
