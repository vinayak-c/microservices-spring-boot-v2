package com.vinayak.microservice.v2.productservice.repository;

import com.vinayak.microservice.v2.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
