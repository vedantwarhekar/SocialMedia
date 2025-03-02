package com.vedant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.vedant.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByEmail(String email);
	
	@Query("select u from User u where u.firstName Like %:query% OR u.lastName Like %:query% OR u.email Like %:query%")
	public List<User> searchUser(@Param("query") String query);
}
