package com.example.elk.first.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.elk.first.demo.model.Product;

public interface ProductSearchService {

	public ResponseEntity<?> createProductIndexBulk(final List<Product> products);
	
	public ResponseEntity<?> createProductIndex(Product products);
	
	public ResponseEntity<?> findProductsByBrand(final String brandName);
	
	public ResponseEntity<?> findByProductName(String name);
	
	public ResponseEntity<?> findByProductPrice(Double greater,Double lesser);
	
	
}
