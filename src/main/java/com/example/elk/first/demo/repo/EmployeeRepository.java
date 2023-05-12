package com.example.elk.first.demo.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.elk.first.demo.model.Employee;
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

	Employee findByFirstname(String firstName);

	Employee findByAge(int age);

	List<Employee> findByFirstnameAndAge(String firstName, int age);

	List<Employee> findByFirstnameOrAge(String firstName, int age);

	List<Employee> findByAgeBetween(int from, int to);

	List<Employee> findByAgeLessThan(int to);

	List<Employee> findByAgeGreaterThan(int from,Pageable pageable);

	List<Employee> findByFirstnameNot(String firstName);

	List<Employee> findByAgeLessThanEqual(int to);

	List<Employee> findByAgeGreaterThanEqual(int from);

	List<Employee> findByFirstnameLike(String firstName);

	List<Employee> findByFirstnameStartingWith(String name);

	List<Employee> findByFirstnameEndingWith(String name);

	List<Employee> findByFirstnameContaining(String name);

	boolean findByFirstnameExists(String name);

	boolean findByFirstnameIsNull(String name);

}
