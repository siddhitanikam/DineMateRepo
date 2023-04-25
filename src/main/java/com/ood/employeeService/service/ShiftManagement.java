package com.ood.employeeService.service;

import java.util.List;

import com.ood.employeeService.model.Schedule;

public interface ShiftManagement {
	
	public List<Schedule> getEmployeeSchedule(int employeeId);
	
	public List<Schedule> getEmployeeSchedule(String shiftDate);
	
	public List<Schedule> getEmployeeSchedule(int employeeId, String shiftDate);
	
	public List<Schedule> getAvailableShifts(String shiftDate);

	
	//public String addShift()
		
}
