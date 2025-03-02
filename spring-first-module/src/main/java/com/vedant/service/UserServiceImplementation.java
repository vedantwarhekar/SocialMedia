package com.vedant.service;

import java.util.List;
import java.util.Optional;

import com.vedant.models.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.vedant.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
    UserRepository userRepository;
	
	@Override
	public User registerUser(User user) throws Exception {
		
		User existingUser = findByEmail(user.getEmail());
		
		if(existingUser != null)
		{
			 throw new Exception("User with given email already exists");
		}
	
		User newUser = new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setGender(user.getGender());
        newUser.setId(user.getId());		
        
        User savedUser = userRepository.save(newUser);
        
		return savedUser;
	}

	@Override
	public User findById(Integer id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent())
		{
			return user.get();
		}		
		
		throw new Exception("User not Exist with the userId "+id);
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer userId1, Integer userId2) throws Exception {
		
		User user1 = findById(userId1);
		
		User user2 = findById(userId2);
		
		user2.getFollowers().add(user1.getId());
		user1.getFollowings().add(user2.getId());
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		return user1;
	}

	@Override
	public User updateUser(User user,Integer userid) throws Exception{
        Optional<User> u1 = userRepository.findById(userid);
    	
    	if(u1.isEmpty())
    	{
    		throw new Exception("user not exists with the userid "+userid);
    	}
    	
    	User oldUser = u1.get();
    	
    	if(user.getFirstName() != null)
    	{
    		oldUser.setFirstName(user.getFirstName());
    	}
    	
    	if(user.getEmail() != null)
    	{
    		oldUser.setEmail(user.getEmail());
    	}	
    	
    	if(user.getLastName() != null)
    	{
    		oldUser.setLastName(user.getLastName());
    	}
    	
    	User updatedUser = userRepository.save(oldUser);
    	
    	return updatedUser;
	}

	@Override
	public List<User> searchUser(String query) {
		
		return userRepository.searchUser(query);
	}

	
}
