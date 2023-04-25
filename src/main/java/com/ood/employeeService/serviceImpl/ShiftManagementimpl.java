package com.ood.employeeService.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.repository.DailyScheduleRepository;
import com.ood.employeeService.service.ShiftManagement;

@Service
public class ShiftManagementimpl implements ShiftManagement{
	
	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;
	
	@Override
	public List<Schedule> getEmployeeSchedule(int employeeId, String shiftDateStr) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date shiftDate;
		List<Schedule> dlyScheduleList = new ArrayList<Schedule>();
		try {
			shiftDate = formatter.parse(shiftDateStr);
			dlyScheduleList = dailyScheduleRepository.findByEmpIdAndShiftDate(employeeId,shiftDate);
			System.out.println("in service -- " + shiftDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dlyScheduleList;
	}
	
	@Override
	public List<Schedule> getEmployeeSchedule(int employeeId) {
		// TODO Auto-generated method stub
		List<Schedule> dlyScheduleList = new ArrayList<Schedule>();
		dlyScheduleList = dailyScheduleRepository.findByEmpId(employeeId);
		return dlyScheduleList;
	}

}
