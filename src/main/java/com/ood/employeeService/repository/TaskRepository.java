package com.ood.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ood.employeeService.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}