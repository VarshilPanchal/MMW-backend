package com.example.mmw.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mmw.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	public User findByUsername(String username);

}
