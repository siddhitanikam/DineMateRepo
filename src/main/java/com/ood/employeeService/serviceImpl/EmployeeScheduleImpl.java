package com.ood.employeeService.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.model.Shift;
import com.ood.employeeService.repository.DailyScheduleRepository;
import com.ood.employeeService.repository.ShiftRepository;
import com.ood.employeeService.service.EmployeeSchedule;

@Service
public class EmployeeScheduleImpl implements EmployeeSchedule{
	
	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Override
	public List<Schedule> getEmployeeSchedule(int employeeId) {
		// TODO Auto-generated method stub
		List<Schedule> dlyScheduleList = new ArrayList<Schedule>();
		dlyScheduleList = dailyScheduleRepository.findByEmpId(employeeId);
		return dlyScheduleList;
	}
	
	@Override
	public List<Schedule> getEmployeeSchedule(String shiftDateStr) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date shiftDate;
		List<Schedule> dlyScheduleList = new ArrayList<Schedule>();
		try {
			shiftDate = formatter.parse(shiftDateStr);
			dlyScheduleList = dailyScheduleRepository.findByShiftDate(shiftDate);
			System.out.println("in service -- " + shiftDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlyScheduleList;
	}
	
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
	public List<Schedule> getAvailableScheduleForSubbinder(String shiftDateStr) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date shiftDate;
		List<Schedule> dlyScheduleList = new ArrayList<Schedule>();
		try {
			shiftDate = formatter.parse(shiftDateStr);
			dlyScheduleList = dailyScheduleRepository.findByDateAndStatus(shiftDate);
			System.out.println("in service -- " + shiftDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlyScheduleList;
		
	}

	@Override
	public List<Shift> getAvailableShifts() {
		// TODO Auto-generated method stub
		List<Shift> shiftList = new ArrayList<Shift>();
		shiftList = shiftRepository.findOpenShifts();
		return shiftList;
		
	}

	@Override
	public List<Shift> getShiftByEmpId(int empId) {
		// TODO Auto-generated method stub
		List<Shift> shiftList = new ArrayList<Shift>();
		shiftList = shiftRepository.findByEmpId(empId);
		return shiftList;
	}

}
