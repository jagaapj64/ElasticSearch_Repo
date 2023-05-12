package com.example.elk.first.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elk.first.demo.model.Employee;
import com.example.elk.first.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/elk")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save/employee")

	public ResponseEntity<?> saveEmployee(@RequestBody List<Employee> emp) {
		return ResponseEntity.ok(employeeService.saveEmployee(emp));
	}

	@GetMapping("/get/all/employee")
	public ResponseEntity<?> fetchAllEmployees() {
		return ResponseEntity.ok(employeeService.fetchAllEmployee());
	}

	@GetMapping("/get/employee/name/{firstName}")
	public ResponseEntity<?> fetchByFirstName(@PathVariable(value="firstName") String firstName) {
		return ResponseEntity.ok(employeeService.findByFirstName(firstName));
	}
	
	@GetMapping("/get/employee/age/{age}")
	public ResponseEntity<?> fetchByAge(@PathVariable(value="age") Integer age) {
		return ResponseEntity.ok(employeeService.findByAge(age));
	}
	
	@GetMapping("/get/employee/name/and/age/{firstName}/{age}")
	public ResponseEntity<?> fetchByFirstnameAndAge(@PathVariable(value="firstName") String firstName,@PathVariable(value="age") Integer age) {
		return ResponseEntity.ok(employeeService.findByFirstNameAndAge(firstName,age));
	}
	
	@GetMapping("/get/employee/name/or/age/{firstName}/{age}")
	public ResponseEntity<?> fetchByFirstnameOrAge(@PathVariable(value="firstName") String firstName,
			                                @PathVariable(value="age") Integer age) {
		return ResponseEntity.ok(employeeService.findByFirstNameOrAge(firstName,age));
	}
	
	@GetMapping("/get/employee/age/between/{from}/{to}")
	public ResponseEntity<?> fetchByAgeBetween(@PathVariable(value="from") Integer from,@PathVariable(value="to") Integer to) {
		return ResponseEntity.ok(employeeService.findByAgeBetween(from,to));
	}
	
	@GetMapping("/get/employee/age/lessthan/{to}")
	public ResponseEntity<?> fetchByAgeLessThan(@PathVariable(value="to") Integer to) {
		return ResponseEntity.ok(employeeService.findByAgeLessThan(to));
	}
	
	@GetMapping("/get/employee/age/greaterthan/{from}")
	public ResponseEntity<?> fetchByAgeGreaterThan(@PathVariable(value="from") Integer from) {
		return ResponseEntity.ok(employeeService.findByAgeGreaterThan(from));
	}
	
	@GetMapping("/get/employee/not/name/{firstName}")
	public ResponseEntity<?> fetchByFirstNameNot(@PathVariable(value="firstName") String firstName) {
		return ResponseEntity.ok(employeeService.findByFirstNameNot(firstName));
	}
	
	@GetMapping("/get/employee/age/lessthan_or_equal/{to}")
	public ResponseEntity<?> fetchByAgeLessThanOrEqual(@PathVariable(value="to") Integer to) {
		return ResponseEntity.ok(employeeService.findByAgeLessThanOrEqual(to));
	}
	
	@GetMapping("/get/employee/age/greaterthan_or_equal/{from}")
	public ResponseEntity<?> fetchByAgeGreaterThanOrEqual(@PathVariable(value="from") Integer from) {
		return ResponseEntity.ok(employeeService.findByAgeGreaterThanOrEqual(from));
	}
	
	@GetMapping("/get/employee/name/like/{firstName}")
	public ResponseEntity<?> fetchByFirstNameLike(@PathVariable(value="firstName") String firstName) {
		return ResponseEntity.ok(employeeService.findByFirstnameLike(firstName));
	}
	
	@GetMapping("/get/employee/name/startwith/{name}")
	public ResponseEntity<?> fetchByFirstNameStartWith(@PathVariable(value="name") String name) {
		return ResponseEntity.ok(employeeService.findByFirstnameStartingWith(name));
	}
	
	@GetMapping("/get/employee/name/endwith/{name}")
	public ResponseEntity<?> fetchByFirstNameEndWith(@PathVariable(value="name") String name) {
		return ResponseEntity.ok(employeeService.findByFirstnameEndingWith(name));
	}
	
	@GetMapping("/get/employee/name/containing/{name}")
	public ResponseEntity<?> fetchByFirstNameContaining(@PathVariable(value="name") String name) {
		return ResponseEntity.ok(employeeService.findByFirstnameContaining(name));
	}
	
	@GetMapping("/get/employee/name/exists/{name}")
	public ResponseEntity<?> findFirstNameExists(@PathVariable(value="name") String name) {
		return ResponseEntity.ok(employeeService.findByFirstnameExists(name));
	}
}
