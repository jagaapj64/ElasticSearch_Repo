package com.example.elk.first.demo.controller;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.bulk.BulkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elk.first.demo.model.Product;
import com.example.elk.first.demo.repo.ProductRepository;
import com.example.elk.first.demo.service.ProductSearchService;

@RestController
@RequestMapping("/api/elk")
public class ProductController {

	@Autowired
	ProductSearchService productSearchService;
	
	@Autowired
	ProductRepository productRepository;

	@PostMapping("/save/all/product")
	public ResponseEntity<?> saveAllProduct(@RequestBody List<Product> prod){
		return productSearchService.createProductIndexBulk(prod);
				
	}
	
	@PostMapping("/save/product")
	public ResponseEntity<?> saveProduct(@RequestBody Product prod){
		return productSearchService.createProductIndex(prod);
				
	}
	
	@PostMapping("/save/product/repo")
	public ResponseEntity<?> saveAllProductRepo(@RequestBody List<Product> prod) throws IOException{
		return productRepository.saveAll(prod);
				
	}
	
	@GetMapping("/get/product/brandname/{brandName}")
	public ResponseEntity<?> findByProductByBrand(@PathVariable(value="brandName") String brandName){
		return productSearchService.findProductsByBrand(brandName);
		
	}
	
	@GetMapping("/get/product/productname/{name}")
	public ResponseEntity<?> findByProductName(@PathVariable(value="name") String name){
		return productSearchService.findByProductName(name);
		
	}
	@GetMapping("/get/product/productprice/{greater}/{lesser}")
	public ResponseEntity<?> findByProductPrice(@PathVariable(value="greater") Double greater,@PathVariable(value="lesser") Double lesser){
		return productSearchService.findByProductPrice(greater,lesser);
		
	}
}
