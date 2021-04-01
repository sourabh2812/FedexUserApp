package com.fedex.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fedex.springboot.entity.UserEntity;
import com.fedex.springboot.repository.UserRepository;
import com.fedex.springboot.service.UserService;
import com.fedex.springboot.value.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(Integer id) {
		return userRepository.findById(id).map(enty -> User.builder().id(enty.getId()).firstName(enty.getFirstName())
				.lastName(enty.getLastName()).build()).get();
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll().stream().map(enty -> User.builder().id(enty.getId())
				.firstName(enty.getFirstName()).lastName(enty.getLastName()).build()).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Integer createUser(User user) {
		return userRepository
				.saveAndFlush(UserEntity.builder().firstName(user.getFirstName()).lastName(user.getLastName()).build())
				.getId();
	}

}
