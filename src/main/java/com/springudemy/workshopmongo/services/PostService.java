package com.springudemy.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springudemy.workshopmongo.domain.Post;
import com.springudemy.workshopmongo.repositories.PostRepository;
import com.springudemy.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
				", Tipo: " + Post.class.getName()));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}

}
