package com.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET, headers = "Accept=application/json")
	@CrossOrigin
	public List<Employee> getListOfEmployees() {
		List<Employee> employees = null;
		employees = employeeService.getListOfEmployees();
		return employees;
	}

}
