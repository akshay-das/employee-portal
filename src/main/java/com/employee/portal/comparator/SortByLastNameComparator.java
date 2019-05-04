package com.employee.portal.comparator;

import java.util.Comparator;

import com.employee.portal.model.Employee;

public class SortByLastNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}

}
