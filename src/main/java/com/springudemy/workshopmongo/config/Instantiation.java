package com.springudemy.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.springudemy.workshopmongo.domain.User;
import com.springudemy.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User user1 = new User(null, "Mário Sousa", "mario.sousa@gmail.com");
		User user2 = new User(null, "Letícia Pereira", "leticia.pereira@gmail.com");
		User user3 = new User(null, "Inácio Gonçalves", "inacio.goncalves@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
	}

}
