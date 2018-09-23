package com.ibm.java.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.java.crud.entities.User;
import com.ibm.java.crud.repos.UserRepository;



@RestController
@RequestMapping ("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List <User> getUsers()
	{
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}
	
	@DeleteMapping(path = "/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		 userRepository.deleteById(id);
		 return true;
	}

	@GetMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
}
