package com.example.mmw.service;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.mmw.document.DatabaseSequence;
import com.example.mmw.document.Product;
import com.example.mmw.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	
	@Autowired
	private MongoOperations mongoOperations;

	public long generateSequence(String seqName) {

		DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	
	public Product updateProduct(Product product) throws Exception {

		Optional<Product> productDetail = productRepository.findById(product.getId());
		if (productDetail.isPresent()) {

			Product updateProduct = productDetail.get();
			updateProduct.setName(product.getName());
			updateProduct.setImage(product.getImage());
			updateProduct.setDetail(product.getDetail());
			updateProduct.setPrize(product.getPrize());
			productRepository.save(updateProduct);
			return updateProduct;
		} else {

			throw new Exception("product is not present !...Get create new product!");

		}

	}
}
