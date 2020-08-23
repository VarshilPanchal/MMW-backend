package com.example.mmw.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long id;

	@Indexed(unique = true)
	private String name;

	private String image;
	private String detail;
	private boolean activeFlag;
	private long prize;

	private Category category;

}
