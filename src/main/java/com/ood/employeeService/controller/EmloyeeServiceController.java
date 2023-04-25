package com.ood.employeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.dto.EmloyeeGetScheduleDTO;
import com.ood.employeeService.service.ShiftManagement;

@RestController
@RequestMapping("/employeeservice/api/v1")
public class EmloyeeServiceController {
	
	@Autowired
	private ShiftManagement shiftManagement;
	
	@GetMapping("/check")
	public ResponseEntity<?> getAllEmployees() {
		System.out.println("checked! ");
		return new ResponseEntity<>("checked", HttpStatus.OK);
	}
	
	@PostMapping("/getScheduleById")
	public List<Schedule> getScheduleById(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return shiftManagement.getEmployeeSchedule(employeeDTO.getEmpId());

	}
	
	@PostMapping("/getScheduleByDate")
	public List<Schedule> getScheduleByDate(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return shiftManagement.getEmployeeSchedule(employeeDTO.getShiftDate());

	}
	
	
	@PostMapping("/getScheduleByIdAndDate")
	public List<Schedule> getScheduleByIdAndDate(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return shiftManagement.getEmployeeSchedule(employeeDTO.getEmpId(), employeeDTO.getShiftDate());

	}
	
	@PostMapping("/getAvailableShifts")
	public List<Schedule> getAvailableShifts(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return shiftManagement.getAvailableShifts(employeeDTO.getShiftDate());

	}
	
	
}
