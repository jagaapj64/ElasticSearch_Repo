package com.example.elk.first.demo.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.elk.first.demo.model.CustomerProduct;
@Repository
public interface CustomerProductRepository extends ElasticsearchRepository<CustomerProduct,String> {

}
