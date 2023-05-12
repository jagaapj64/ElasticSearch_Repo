package com.example.elk.first.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.elk.first.demo.model.Employee;
import com.example.elk.first.demo.repo.EmployeeRepository;
import com.example.elk.first.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public int saveEmployee(List<Employee> employees) {
		employeeRepository.saveAll(employees);
		System.out.println(employees.toString());
		return employees.size();
	}

	@Override
	public Iterable<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByFirstName(String firstName) {
		return employeeRepository.findByFirstname(firstName);
	}

	@Override
	public Employee findByAge(int age) {
		return employeeRepository.findByAge(age);
	}

	@Override
	public List<Employee> findByFirstNameAndAge(String firstName, int age) {
		return employeeRepository.findByFirstnameAndAge(firstName, age);
	}

	@Override
	public List<Employee> findByFirstNameOrAge(String firstName, int age) {
		return employeeRepository.findByFirstnameOrAge(firstName, age);
	}

	@Override
	public List<Employee> findByAgeBetween(int from, int to) {
		return employeeRepository.findByAgeBetween(from, to);
	}

	@Override
	public List<Employee> findByAgeLessThan(int to) {
		return employeeRepository.findByAgeLessThan(to);
	}

	@Override
	public List<Employee> findByAgeGreaterThan(int from) {
		return employeeRepository.findByAgeGreaterThan(from,PageRequest.of(0, 5));
	}

	@Override
	public List<Employee> findByFirstNameNot(String firstName) {
		return employeeRepository.findByFirstnameNot(firstName);
	}

	@Override
	public List<Employee> findByAgeLessThanOrEqual(int to) {
		return employeeRepository.findByAgeLessThanEqual(to);
	}

	@Override
	public List<Employee> findByAgeGreaterThanOrEqual(int from) {
		return employeeRepository.findByAgeGreaterThanEqual(from);
	}

	@Override
	public List<Employee> findByFirstnameLike(String firstName) {
		return employeeRepository.findByFirstnameLike(firstName);
	}

	@Override
	public List<Employee> findByFirstnameStartingWith(String name) {
		return employeeRepository.findByFirstnameStartingWith(name);
	}

	@Override
	public List<Employee> findByFirstnameEndingWith(String name) {
		return employeeRepository.findByFirstnameEndingWith(name);
	}

	@Override
	public List<Employee> findByFirstnameContaining(String name) {
		return employeeRepository.findByFirstnameContaining(name);
	}

	@Override
	public String findByFirstnameExists(String name) {
		boolean result = employeeRepository.findByFirstnameIsNull(name);

		if (result == true)
			return "Employee is already exists";
		else
			return "Employee is Not Already exists";
	}

}
