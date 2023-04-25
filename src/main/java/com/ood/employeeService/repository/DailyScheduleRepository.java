package com.ood.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ood.employeeService.model.Schedule;

@Repository
public interface DailyScheduleRepository extends JpaRepository<Schedule, Integer>{

}
