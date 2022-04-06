package com.springudemy.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springudemy.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> users = new ArrayList<>();
		User user1 = new User("1001", "Lucas Mendes", "lucas.mendes@gmail.com");
		User user2 = new User("1002", "Maria Silva", "maria.silva@gmail.com");
		
		users.addAll(Arrays.asList(user1, user2));
		
		return ResponseEntity.ok().body(users);
	}

}
