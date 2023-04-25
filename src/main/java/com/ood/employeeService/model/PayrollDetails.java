package com.ood.employeeService.model;

import java.util.Date;

public class PayrollDetails {
	private int id;
	private Date startDate;
	private Date endDate;
	private float paymentRate;
	private char paymentType;
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(float paymentRate) {
		this.paymentRate = paymentRate;
	}

	public char getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(char paymentType) {
		this.paymentType = paymentType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
