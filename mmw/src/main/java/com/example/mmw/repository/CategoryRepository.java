package com.example.mmw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mmw.document.Category;
import com.example.mmw.document.Product;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
