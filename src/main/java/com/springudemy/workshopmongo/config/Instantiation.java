package com.springudemy.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springudemy.workshopmongo.domain.Post;
import com.springudemy.workshopmongo.domain.User;
import com.springudemy.workshopmongo.dto.AuthorDTO;
import com.springudemy.workshopmongo.repositories.PostRepository;
import com.springudemy.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User user1 = new User(null, "Mário Sousa", "mario.sousa@gmail.com");
		User user2 = new User(null, "Letícia Pereira", "leticia.pereira@gmail.com");
		User user3 = new User(null, "Inácio Gonçalves", "inacio.goncalves@gmail.com");		
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP. Abraços!", new AuthorDTO(user1));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje!!", new AuthorDTO(user1));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(user1);
		
	}

}
