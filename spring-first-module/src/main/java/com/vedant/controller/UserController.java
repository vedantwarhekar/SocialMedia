package com.vedant.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


import com.vedant.models.User;
import com.vedant.repository.UserRepository;
import com.vedant.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	 
	@PostMapping("/add-user")
    public User addUser(@RequestBody User user) throws Exception
	{
        User savedUser = userService.registerUser(user);	   
	    return savedUser;
	}
	
    @GetMapping("/get-all-users")
	public List<User> getUser() {
    	
		List<User> users = userRepository.findAll();
		
		return users;
	}
    
    @GetMapping("/user/{userid}")
    public User getUserById(@PathVariable("userid")Integer id) throws Exception 
    {
    	User user = userService.findById(id);
    	
    	return user;
    }
    
    @PutMapping("/update-user/{userid}")
    public User updateUser(@RequestBody User user,@PathVariable Integer userid) throws Exception
    {
    	User updateUser = userService.updateUser(user, userid);
    	
    	return updateUser;
    }
    
    @PutMapping("/user/follow/{userId1}/{userId2}")
    public User followUserHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception
    {
    	User user = userService.followUser(userId1, userId2);
    	return user;
    }
    
    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query)
    {
    	List<User> user = userService.searchUser(query);
    	
    	return user;
    }
    
   
    
}
