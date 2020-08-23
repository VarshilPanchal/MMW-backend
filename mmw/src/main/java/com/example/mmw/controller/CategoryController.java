package com.example.mmw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mmw.document.Category;
import com.example.mmw.repository.CategoryRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping(value = "category")
	public ResponseEntity<List<Category>> getCategories() {
		return ResponseEntity.ok().body(categoryRepository.findAll());
	}
}
