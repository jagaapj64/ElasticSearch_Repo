package com.example.elk.first.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.elk.first.demo.model.Product;
import com.example.elk.first.demo.service.ProductSearchService;

@Service
public class ProductSearchServiceImpl implements ProductSearchService {

	private static final String PRODUCT_INDEX = "productindex";

	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	

	@Override
	public ResponseEntity<?> createProductIndexBulk(List<Product> products) {
		List<IndexQuery> queries = products.stream()
				.map(prod -> new IndexQueryBuilder().withId(prod.getId().toString()).withObject(prod).build())
				.collect(Collectors.toList());
		List<IndexedObjectInformation> response = elasticsearchOperations.bulkIndex(queries,
				IndexCoordinates.of(PRODUCT_INDEX));
		response.forEach(ele -> {
			System.out.println(ele);
		});
		return ResponseEntity.ok(response);

	}

	@Override
	public ResponseEntity<?> createProductIndex(Product products) {

		IndexQuery queries = new IndexQueryBuilder().withId(products.getId()).withObject(products).build();
		String document = elasticsearchOperations.index(queries, IndexCoordinates.of(PRODUCT_INDEX));
		System.out.println(document);
		return ResponseEntity.ok(document);
	}

	@Override
	public ResponseEntity<?> findProductsByBrand(String brandName) {

		QueryBuilder queryBuilder = QueryBuilders.matchQuery("manufacturer", brandName);

		Query searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();

		SearchHits<Product> searchHits = elasticsearchOperations.search(searchQuery, Product.class,
				IndexCoordinates.of(PRODUCT_INDEX));
		return ResponseEntity.ok(searchHits);
	}

	@Override
	public ResponseEntity<?> findByProductName(String name) {

		Query searchQuery = new StringQuery("{\"match\":{\"name\":{\"query\":\""+ name + "\"}}}\"");
		 SearchHits<Product> products=elasticsearchOperations.search(searchQuery, Product.class, IndexCoordinates.of(PRODUCT_INDEX));
		 return ResponseEntity.ok(products);
	}

	@Override
	public ResponseEntity<?> findByProductPrice(Double greater,Double lesser) {

		Criteria creCriteria=new Criteria("price").greaterThan(greater).lessThan(lesser);
		
		Query searchQuery=new CriteriaQuery(creCriteria);
		
		SearchHits<Product> products=
				elasticsearchOperations.search(searchQuery, Product.class, IndexCoordinates.of(PRODUCT_INDEX));
		return ResponseEntity.ok(products);
	}
}
