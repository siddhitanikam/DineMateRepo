package com.ood.employeeService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ood.employeeService.model.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer>{
	public final static String getEmployeeScheduleById ="Select s from Shift s Join employee em Where em.empId = :empId";
	
	@Query(getEmployeeScheduleById)
	List<Shift> findByEmpId(int empId);

}
