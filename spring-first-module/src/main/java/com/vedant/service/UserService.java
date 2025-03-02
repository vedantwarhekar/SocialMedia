package com.vedant.service;

import com.vedant.models.User;

import java.util.List;

public interface UserService {

	public User registerUser(User user) throws Exception;
	
	public User findById(Integer id) throws Exception;
	
	public User findByEmail(String email);
	
	public User followUser(Integer userId1,Integer userId2) throws Exception;
	
	public User updateUser(User user,Integer id) throws Exception;
	
	public List<User> searchUser(String query);
}
