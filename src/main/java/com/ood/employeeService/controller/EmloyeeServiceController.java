package com.ood.employeeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.model.Employee;
import com.ood.employeeService.service.ShiftManagement;

@RestController
@RequestMapping("/employeeservice/api/v1")
public class EmloyeeServiceController {
	
	@Autowired
	private ShiftManagement shiftManagemet;
	
	@GetMapping("/check")
	public ResponseEntity<?> getAllEmployees() {
		System.out.println("checked! ");
		return new ResponseEntity<>("checked", HttpStatus.OK);
	}
	
	@PostMapping("/getSchedule")
	public Schedule getSchedule(@RequestBody Employee employee) {
		System.out.println("In controller");
		return shiftManagemet.getEmployeeSchedule(employee.getEmpId());

	}
}
