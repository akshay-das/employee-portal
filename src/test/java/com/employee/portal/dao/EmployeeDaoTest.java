package com.employee.portal.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.portal.model.Department;
import com.employee.portal.model.Employee;
import com.employee.portal.model.Gender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

	@Autowired
	EmployeeDao emloyeeDao;

	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll() {
		Collection<Employee> returnList = emloyeeDao.findAllByOrderByFirstName();

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

	@Test
	public void testSave() {
		Employee e = new Employee(11, "test", "testlastname", null, Gender.MALE, Department.FINANCE);
		boolean result = emloyeeDao.save(e);
		assertThat("Result should be true", result, is(true));
		assertThat("The list doesn't contain the expected values.", emloyeeDao.findAllByOrderByFirstName().size(),
				is(3));

	}

}
