package com.todo.persistance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.persistance.dao.EmployeDao;
import com.todo.persistance.model.Employee;
import com.todo.persistance.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeDao employeDao;

	@Transactional
	public Employee createEmployee(Employee employee) {
		employeDao.save(employee);

		return employee;
	}

	public List<Employee> getAllEmployee() {
		return employeDao.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeDao.findByPrimaryKey(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		employeDao.update(employee);
		return employee;
	}


}
