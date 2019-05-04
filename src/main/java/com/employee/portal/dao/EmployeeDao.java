package com.employee.portal.dao;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.employee.portal.model.Department;
import com.employee.portal.model.Employee;
import com.employee.portal.model.Gender;

@Component
public class EmployeeDao {

	private static SortedSet<Employee> employeeSet = new TreeSet<Employee>();

	public Collection<Employee> findAllByOrderByFirstName() {
		return employeeSet;

	}

	public boolean save(Employee employee) {
		return employeeSet.add(employee);

	}

	@PostConstruct
	void loadCache() {

		Employee e = new Employee(1, "fn", "ln", null, Gender.MALE, Department.FINANCE);
		employeeSet.add(e);
		Employee e1 = new Employee(2, "fname", "ln", null, Gender.FEMALE, Department.HR);
		employeeSet.add(e1);
	}

}
