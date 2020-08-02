package com.example.mmw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mmw.document.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
