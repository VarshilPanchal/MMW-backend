package com.example.mmw.document;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

	@Id
	@Indexed
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	private String email;

	@NotBlank
	@Size(min = 6)
	private String password;

	@NotBlank
	@Size(min = 6)
	private String confirmPassword;

//	@DBRef(db = )
	private Set<Roles> roles = new HashSet<>();

}
