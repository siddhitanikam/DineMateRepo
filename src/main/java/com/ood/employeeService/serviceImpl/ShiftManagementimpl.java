package com.ood.employeeService.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ood.employeeService.dto.TaskAssignmentDTO;
import com.ood.employeeService.model.Employee;
import com.ood.employeeService.model.Schedule;
import com.ood.employeeService.model.Shift;
import com.ood.employeeService.model.Status;
import com.ood.employeeService.model.Task;
import com.ood.employeeService.repository.DailyScheduleRepository;
import com.ood.employeeService.repository.EmployeeRepository;
import com.ood.employeeService.repository.ShiftRepository;
import com.ood.employeeService.repository.StatusRepository;
import com.ood.employeeService.repository.TaskRepository;
import com.ood.employeeService.service.ShiftManagement;

@Service
public class ShiftManagementImpl implements ShiftManagement{
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Shift> getShifts(int employeeId) {
		// TODO Auto-generated method stub
		List<Shift> shiftlist = new ArrayList<Shift>();
		shiftlist = shiftRepository.findByEmpId(employeeId);
		return shiftlist;
	}
	
	@Override
	public String addShiftToSubBinder(int scheduleId) {
		Status s = new Status();
		s.setStatusId(2);
		s.setStatus("Pending");
		Schedule sl = dailyScheduleRepository.findById(scheduleId).get();
		sl.setStatus(s);
		return dailyScheduleRepository.save(sl) != null ? "Success" : "Failed" ;
	}
	
	@Override
	public String pickSubBinderShift(int employeeId, int scheduleId) {
		Status s = new Status();
		s.setStatusId(1);
		s.setStatus("Working");
		Schedule sl = dailyScheduleRepository.findById(scheduleId).get();
		Employee emp = employeeRepository.findById(employeeId).get();
		sl.setStatus(s);
		sl.setEmployee(emp);
		return dailyScheduleRepository.save(sl) != null ? "Success":"Failed";
	}

	@Override
	public String addShift(int shiftId, int employeeId) {
		// TODO Auto-generated method stub
		Shift shift = shiftRepository.findById(shiftId).get();
		Employee emp = employeeRepository.findById(employeeId).get();
		shift.setEmployee(emp);
		return shiftRepository.save(shift)!=null ? "Success" : "Failed";
	}

	@Override
	public String dropShift(int shiftId) {
		// TODO Auto-generated method stub
		Shift shift = shiftRepository.findById(shiftId).get();
		shift.setEmployee(null);
		return shiftRepository.save(shift)!=null ? "Success" : "Failed";
	}
	
	@Override
	public String assignTask(TaskAssignmentDTO taskAssignmentDTO) {
		
		//AttendenceTypes attendenceTypes = AttendenceTypesRepository
		Schedule schedule = dailyScheduleRepository.findById(taskAssignmentDTO.getScheduleId()).get();
		Status status = statusRepository.findById(taskAssignmentDTO.getStatusId()).get();
		Task task = taskRepository.findById(taskAssignmentDTO.getTaskId()).get();
		Employee employee = employeeRepository.findById(schedule.getEmployee().getEmpId()).get();
		schedule.setTask(task);
		schedule.setStatus(status);
		employee.setDwpoints(employee.getDwpoints() + status.getDWpoints());
		schedule.setEmployee(employee);
		return dailyScheduleRepository.save(schedule) != null?"Success":"Failed";
	}
}
