package com.ood.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ood.employeeService.model.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer>{

}
