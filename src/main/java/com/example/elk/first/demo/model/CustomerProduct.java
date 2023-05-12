package com.example.elk.first.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "customer_productindex", createIndex = true)
public class CustomerProduct {

	@Id
	private String id;
	
//	@Field(type = FieldType.Text, name = "Name")
//	private String Name;
//	
//	@Field(type = FieldType.Text, name = "Description")
//	private String Description;
//	
//	@Field(type = FieldType.Text, name = "Manufacturer")
//	private String Manufacturer;
	
	@Field(type = FieldType.Integer, name = "InvoiceNo")
	private Integer InvoiceNo;
	
	@Field(type = FieldType.Text, name = "StockCode")
	private String StockCode;
	
	@Field(type = FieldType.Text, name = "Description")
	private String Description;
	
	@Field(type = FieldType.Text, name = "Quantity")
	private Integer Quantity;
	
	@Field(type = FieldType.Text, name = "InvoiceDate")
	private String InvoiceDate;
	
	@Field(type = FieldType.Double, name = "UnitPrice")
	private Double UnitPrice;
	
	@Field(type = FieldType.Text, name = "CustomerID")
	private Integer CustomerID;
	
	@Field(type = FieldType.Text, name = "Country")
	private String Country;

}
