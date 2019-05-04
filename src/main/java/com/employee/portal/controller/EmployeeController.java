package com.employee.portal.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.portal.model.Employee;
import com.employee.portal.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Employee Management System", description = "Operations pertaining to employees in Employee Management System")
@RequestMapping({ "/employee" })
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@ApiOperation(value = "View  list of available employees", response = Employee.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public Collection<Employee> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Create new employee", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created new employee"),
			@ApiResponse(code = 401, message = "You are not authorized to create the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/create")
	public boolean create(@ApiParam(value = "New employee", required = true) @RequestBody Employee employee) {
		System.out.println("inside post");
		return service.save(employee);
	}
}
