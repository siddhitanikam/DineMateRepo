package com.ood.employeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.model.Shift;
import com.ood.employeeService.dto.EmloyeeGetScheduleDTO;
import com.ood.employeeService.dto.TaskAssignmentDTO;
import com.ood.employeeService.service.EmployeeSchedule;
import com.ood.employeeService.service.ShiftManagement;

@RestController
@RequestMapping("/employeeservice/api/v1")
public class EmloyeeServiceController {
	
	@Autowired
	private EmployeeSchedule employeeSchedule;
	
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
		return employeeSchedule.getEmployeeSchedule(employeeDTO.getEmpId());

	}
	
	@PostMapping("/getScheduleByDate")
	public List<Schedule> getScheduleByDate(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return employeeSchedule.getEmployeeSchedule(employeeDTO.getShiftDate());
	}
	
	
	@PostMapping("/getScheduleByIdAndDate")
	public List<Schedule> getScheduleByIdAndDate(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return employeeSchedule.getEmployeeSchedule(employeeDTO.getEmpId(), employeeDTO.getShiftDate());
	}
	
	@PostMapping("/getAvailableScheduleForSubbinder")
	public List<Schedule> getScheduleByDateAndStatus(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return employeeSchedule.getAvailableScheduleForSubbinder(employeeDTO.getShiftDate());
	}
	
	@PostMapping("/getAvailableShifts")
	public List<Shift> getAvailableShifts() {
		System.out.println("In controller");
		return employeeSchedule.getAvailableShifts();

	}
	
	@PostMapping("/getShiftByEmpId")
	public List<Shift> getYourhifts(@RequestBody EmloyeeGetScheduleDTO employeeDTO) {
		System.out.println("In controller");
		return employeeSchedule.getShiftByEmpId(employeeDTO.getEmpId());

	}
	
	@GetMapping("/addToSubBinder/{scheduleId}")
	public ResponseEntity<?> addShiftToSubBinder(@PathVariable(name = "scheduleId", required = true) int scheduleId) {
		
		return new ResponseEntity<>(shiftManagement.addShiftToSubBinder(scheduleId), HttpStatus.OK);
	} 
	
	@PostMapping("/pickFromSubBinder")
	public ResponseEntity<?> pickSubBinderShift(@RequestBody EmloyeeGetScheduleDTO scheduleDTO) {
		
		return new ResponseEntity<>(shiftManagement.pickSubBinderShift(scheduleDTO.getEmpId(), scheduleDTO.getScheduleId()), HttpStatus.OK);
	}
	
	@GetMapping("/dropShift/{shiftId}")
	public ResponseEntity<?> dropShift(@PathVariable(name = "shiftId", required = true) int shiftId) {
		
		return new ResponseEntity<>(shiftManagement.dropShift(shiftId), HttpStatus.OK);
	} 
	
	@PostMapping("/addShift")
	public ResponseEntity<?> addShift(@RequestBody EmloyeeGetScheduleDTO scheduleDTO) {
		
		return new ResponseEntity<>(shiftManagement.addShift(scheduleDTO.getShiftId(), scheduleDTO.getEmpId()), HttpStatus.OK);
	}
	
	@PostMapping("/assignTask")
	public ResponseEntity<?> assignTaskHandler(@RequestBody TaskAssignmentDTO taskAssignmentDTO) {
		
		return new ResponseEntity<>(shiftManagement.assignTask(taskAssignmentDTO), HttpStatus.OK);
	}
	
	
}
