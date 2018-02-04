package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;

	@Column(name = "DEPTID")
	private int deptId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SALARY")
	private double salary;
	
	public Employee() {

	}

	public Employee(int id, int deptId, String name, double salary) {
		this.id = id;
		this.deptId = deptId;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
