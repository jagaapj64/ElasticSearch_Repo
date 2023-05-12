package com.example.elk.first.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "employeeindex")

public class Employee {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private int age;
}
