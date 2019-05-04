package com.employee.portal.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.portal.dao.EmployeeDao;
import com.employee.portal.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public Collection<Employee> findAll() {
		return employeeDao.findAllByOrderByFirstName();
	}

	public boolean save(Employee employee) {
		return employeeDao.save(employee);
	}

}
