package com.fedex.springboot.service;

import java.util.List;

import com.fedex.springboot.value.User;

public interface UserService {

	public User getUser(Integer id);

	public List<User> getUsers();

	public Integer createUser(User user);

}
