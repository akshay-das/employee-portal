package com.employee.portal.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.portal.model.Department;
import com.employee.portal.model.Employee;
import com.employee.portal.model.Gender;
import com.employee.portal.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Test
	public void testCreate() {

		Employee e = new Employee(1, "fn", "ln", null, Gender.MALE, Department.FINANCE);
		doReturn(true).when(employeeService).save(e);

		boolean returnEmp = employeeController.create(e);
		assertThat("Resutl should be true", returnEmp, is(true));

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testfindAll() {

		List<Employee> list = new ArrayList<>();
		Employee e = new Employee(1, "fn", "ln", null, Gender.MALE, Department.FINANCE);
		list.add(e);
		Employee e1 = new Employee(2, "fname", "ln", null, Gender.FEMALE, Department.HR);
		list.add(e1);
		doReturn(list).when(employeeService).findAll();

		Collection<Employee> returnList = employeeController.findAll();

		assertThat("The list doesn't contain the expected values.", returnList,
				contains(hasProperty("id", is(1L)), hasProperty("id", is(2L))));

		assertThat("The list doesn't contain the expected values.", returnList,
				contains(hasProperty("firstName", is("fn")), hasProperty("firstName", is("fname"))));

		assertThat("The list doesn't contain the expected values.", returnList,
				contains(hasProperty("lastName", is("ln")), hasProperty("lastName", is("ln"))));

		assertThat("The list doesn't contain the expected values.", returnList,
				contains(hasProperty("gender", is(Gender.MALE)), hasProperty("gender", is(Gender.FEMALE))));

		assertThat("The list doesn't contain the expected values.", returnList, contains(
				hasProperty("department", is(Department.FINANCE)), hasProperty("department", is(Department.HR))));

	}

}
