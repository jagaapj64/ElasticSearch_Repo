package com.example.elk.first.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Document(indexName = "productindex",createIndex = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@Id
	private String id;
	@Field(type = FieldType.Text, name = "name")
	private String name;
	@Field(type = FieldType.Double, name = "price")
	private Double price;
	@Field(type = FieldType.Integer, name = "quantity")
	private Integer quantity;
	@Field(type = FieldType.Text, name = "category")
	private String category;
	@Field(type = FieldType.Text, name = "description")
	private String description;
	@Field(type = FieldType.Text, name = "manufacturer")
	private String manufacturer;

}
