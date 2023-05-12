package com.example.elk.first.demo.repo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.elk.first.demo.config.ElasticConfig;
import com.example.elk.first.demo.model.Product;
import com.example.elk.first.demo.request.SearchQueryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	ElasticConfig elasticConfig;

	@Autowired
	ObjectMapper objectMapper;

//	https://github.com/luthfihariz/learn-eswithspring

	private static final String INDEX_NAME = "productindex";

	@Override
	public SearchResponse search(SearchQueryDto searchQueryDto) throws IOException {
		return null;
	}

	@Override
	public IndexResponse saves(Product product) throws IOException {
		return null;
	}

	@Override
	public ResponseEntity<?> saveAll(List<Product> products) throws IOException {
		BulkRequest bulkRequest = Requests.bulkRequest();
		products.forEach(product -> {
			try {
				IndexRequest indexRequest = Requests.indexRequest(INDEX_NAME).source(convertProductToMap(product));
				bulkRequest.add(indexRequest);
			} catch (JsonProcessingException e) {
				// log error
			}
		});

		RequestOptions options = RequestOptions.DEFAULT;
		BulkResponse res = elasticConfig.restClient().bulk(bulkRequest, options);
		 RestStatus list = res.status();
		 System.out.println("status "+res.status()+"time "+res.getIngestTookInMillis());
		return ResponseEntity.ok("status :"+res.status()+" time :"+res.getIngestTookInMillis());
	}

	private Map<String, Product> convertProductToMap(Product product) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(product);
		System.out.println(json);
		return objectMapper.readValue(json, Map.class);
	}

}
