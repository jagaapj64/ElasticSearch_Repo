package com.example.elk.first.demo.service;

import java.util.List;

import com.example.elk.first.demo.model.Employee;

public interface EmployeeService {

	int saveEmployee(List<Employee> employees);

	Iterable<Employee> fetchAllEmployee();

	Employee findByFirstName(String firstName);

	Employee findByAge(int age);

	List<Employee> findByFirstNameAndAge(String firstName, int age);

	List<Employee> findByFirstNameOrAge(String firstName, int age);

	List<Employee> findByAgeBetween(int from, int to);

	List<Employee> findByAgeLessThan(int to);

	List<Employee> findByAgeGreaterThan(int from);

	List<Employee> findByFirstNameNot(String firstName);

	List<Employee> findByAgeLessThanOrEqual(int to);

	List<Employee> findByAgeGreaterThanOrEqual(int from);

	List<Employee> findByFirstnameLike(String firstName);

	List<Employee> findByFirstnameStartingWith(String name);

	List<Employee> findByFirstnameEndingWith(String name);
	
	List<Employee> findByFirstnameContaining(String name);
	
	String findByFirstnameExists(String name);
	
	
	
}
