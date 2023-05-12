package com.example.elk.first.demo.repo;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.elk.first.demo.model.Product;
import com.example.elk.first.demo.request.SearchQueryDto;

@Repository
public interface ProductRepository  {

//	https://github.com/luthfihariz/learn-eswithspring
	SearchResponse search(SearchQueryDto searchQueryDto) throws IOException;

	IndexResponse saves(Product product) throws IOException;

	ResponseEntity<?> saveAll(List<Product> products) throws IOException;
}
