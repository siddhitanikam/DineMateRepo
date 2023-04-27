package com.ood.employeeService.service;

import java.util.List;

import com.ood.employeeService.dto.TaskAssignmentDTO;
import com.ood.employeeService.model.Shift;

public interface ShiftManagement {
	public String addShiftToSubBinder(int scheduleId);
	
	public String pickSubBinderShift(int employeeId, int scheduleId);
	
	public List<Shift> getShifts(int employeeId);
	
	public String addShift(int shiftId, int employeeId);
	
	public String dropShift(int shiftId);

	public String assignTask(TaskAssignmentDTO taskAssignmentDTO);
}
