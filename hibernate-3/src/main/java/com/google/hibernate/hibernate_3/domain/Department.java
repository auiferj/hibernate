package com.google.hibernate.hibernate_3.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private int id;
	private String name;
	// 也可以只由员工维护关系，部门不维护关系，Set<Employee>
	// employeeSet属性可以去掉，对应的Department.hbm.xml中的<set
	// name="employeeSet"/>也要去掉，这时二者的关系只在员工中维护；
	private Set<Employee> employeeSet = new HashSet<Employee>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
