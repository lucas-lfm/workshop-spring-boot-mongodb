package com.springudemy.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springudemy.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Transactional(readOnly=true)
	public List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{'title': {$regex: ?0, $options: 'i'}}")
	public List<Post> searchTitle(String text);
	
}
