package com.springudemy.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springudemy.workshopmongo.domain.User;
import com.springudemy.workshopmongo.dto.UserDTO;
import com.springudemy.workshopmongo.repositories.UserRepository;
import com.springudemy.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
				", Tipo: " + User.class.getName()));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(String id) {
		User user = findById(id);
		userRepository.delete(user);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		userDTO.setId(null);
		User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
		return user;
	}

}
