package com.todo.persistance.service;

import java.util.List;

import com.todo.persistance.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(Long id);

}
