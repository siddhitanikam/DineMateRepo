package com.ood.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ood.employeeService.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}