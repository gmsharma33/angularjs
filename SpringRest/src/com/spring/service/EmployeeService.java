package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * @return
	 */
	public List<Employee> getListOfEmployees() {
		return employeeDao.getListOfEmployees();
	}
	
}
