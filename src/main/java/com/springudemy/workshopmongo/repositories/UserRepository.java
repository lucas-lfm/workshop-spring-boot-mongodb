package com.springudemy.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springudemy.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
