package com.fedex.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import com.fedex.springboot.service.UserService;
import com.fedex.springboot.value.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWS {

	@Autowired
	private UserService userService;

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<Integer> createUser(@RequestBody @Valid User user) {
		return new ResponseEntity<Integer>(userService.createUser(user), HttpStatus.CREATED);
	}
}
