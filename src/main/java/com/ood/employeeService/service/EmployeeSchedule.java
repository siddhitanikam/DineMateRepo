package com.ood.employeeService.service;

import java.util.List;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.model.Shift;

public interface EmployeeSchedule {
	
	public List<Schedule> getEmployeeSchedule(int employeeId);
	
	public List<Schedule> getEmployeeSchedule(String shiftDate);
	
	public List<Schedule> getEmployeeSchedule(int employeeId, String shiftDate);
	
	public List<Shift> getAvailableShifts();
	
	public List<Shift> getShiftByEmpId(int employeeId);
	
	public List<Schedule> getAvailableScheduleForSubbinder(String shiftDate);

}
