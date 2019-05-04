package com.employee.portal.model;

import java.time.LocalDate;

import com.employee.portal.date.LocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "All details about Employee. ")
public class Employee implements Comparable<Employee> {

	@ApiModelProperty(example = "1", notes = "The employee ID")
	private long id;
	@ApiModelProperty(example = "Akshay", notes = "The employee first name")
	private String firstName;
	@ApiModelProperty(example = "Das", notes = "The employee last name")
	private String lastName;
	@ApiModelProperty(example = "2009-11-22", notes = "The employee date of birth")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dob;
	@ApiModelProperty(example = "MALE", notes = "The employee Gender")
	private Gender gender;
	@ApiModelProperty(example = "HR", notes = "The employee department")
	private Department department;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (department != other.department)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(Employee o) {
		return this.getFirstName().compareTo(o.getFirstName());
	}

}
