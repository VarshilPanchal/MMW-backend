package com.example.mmw.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mmw.document.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

	@Query(value = "{'category.name':?0}")
	public List<Product> getProductsByCategory(String name);
}
