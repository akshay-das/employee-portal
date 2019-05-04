package com.employee.portal.comparator;

import java.util.Comparator;

import com.employee.portal.model.Employee;

public class SortByIdComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getId() < o2.getId()) {
			return -1;
		}
		if (o2.getId() > o2.getId()) {
			return 1;
		}
		return 0;
	}
}
