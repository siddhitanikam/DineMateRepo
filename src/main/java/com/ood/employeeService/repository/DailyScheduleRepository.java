package com.ood.employeeService.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ood.employeeService.model.Schedule;

@Repository
public interface DailyScheduleRepository extends JpaRepository<Schedule, Integer>{
	
	public final static String getEmployeeScheduleById ="Select s from Schedule s Join employee em Where em.empId = :empId";
	public final static String getEmployeeScheduleByDate ="Select s from Schedule s Where shiftDate = :shiftDate";
	public final static String getEmployeeScheduleByIdAndDate ="Select s from Schedule s Join s.employee em Where em.empId = :empId and shiftDate = :shiftDate";
	public final static String getAvailableShifts ="Select s from Schedule s Join s.status st Where shiftDate = :shiftDate and st.status = \"Pending\"";

	
	@Query(getEmployeeScheduleById)
	List<Schedule> findByEmpId(int empId);
	
	@Query(getEmployeeScheduleByDate)
	List<Schedule> findByShiftDate(Date shiftDate);

	@Query(getEmployeeScheduleByIdAndDate)
	List<Schedule> findByEmpIdAndShiftDate(int empId, Date shiftDate);
	
	@Query(getAvailableShifts)
	List<Schedule> findByDateAndStatus(Date shiftDate);
	
	
	
}
