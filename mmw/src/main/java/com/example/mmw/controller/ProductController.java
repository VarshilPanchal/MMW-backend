package com.example.mmw.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mmw.document.Product;
import com.example.mmw.repository.ProductRepository;
import com.example.mmw.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@GetMapping(path = "products")
	public ResponseEntity<?> getProducts(@RequestParam Long id) {

		if (id != null) {
			if (productRepository.findById(id).isPresent()) {
				return ResponseEntity.ok().body(productRepository.findById(id));
			} else {
				return ResponseEntity.badRequest().body("product is not present");
			}
		}
		return ResponseEntity.ok().body(productRepository.findAll());
	}

	@PostMapping(path = "products")
	public ResponseEntity<?> saveProduct(@RequestBody Product entity) {
		entity.setId(productService.generateSequence(Product.SEQUENCE_NAME));

		productRepository.save(entity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(entity.getId()).toUri();

		return ResponseEntity.created(uri).build();

		// .body(new Product(entity.getId(), entity.getName(), entity.getImage(),
		// entity.getDetail(),
//				entity.isActiveFlag(), entity.getPrize()));
	}

	@DeleteMapping(path = "products")
	public void deleteProduct(@RequestParam Long id) {
		if (id != null) {
			Optional<Product> productDetail = productRepository.findById(id);

			if (productDetail.isPresent()) {

				productRepository.deleteById(id);
				ResponseEntity.ok("product of id " + id + " successfully deleted");
			}
		}
		((BodyBuilder) ResponseEntity.notFound()).body("product  is not present...");
	}

	@PutMapping(path = "products")
	public ResponseEntity<?> updateProduct(@RequestBody Product entity) throws Exception {
		return ResponseEntity.ok().body(productService.updateProduct(entity));

	}

	@GetMapping(value = "products/category/{name}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String name) {
		return ResponseEntity.ok().body(productRepository.getProductsByCategory(name));
	}

}
