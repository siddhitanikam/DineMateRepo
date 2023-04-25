package com.ood.employeeService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.repository.DailyScheduleRepository;
import com.ood.employeeService.repository.EmployeeRepository;
import com.ood.employeeService.repository.ShiftRepository;
import com.ood.employeeService.service.ShiftManagement;

@Service
public class ShiftManagementimpl implements ShiftManagement{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;
	
	@Override
	public Schedule getEmployeeSchedule(int employeeId) {
		// TODO Auto-generated method stub
		Schedule dlySchedule = dailyScheduleRepository.findById(employeeId).get();
		System.out.println("in service " );
		return dlySchedule;
	}

}
