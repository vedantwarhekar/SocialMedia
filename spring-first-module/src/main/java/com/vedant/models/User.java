package com.vedant.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ElementCollection;

import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name="users")
public class User {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
    @ElementCollection
	private List<Integer> followers = new ArrayList<>();
    @ElementCollection
	private List<Integer> followings = new ArrayList<>();
	@OneToMany
	private List<Post> savedPost = new ArrayList<>();
	
	public User() {
		// default contrustor
	}

    public User(Integer id, String firstName, String lastName, String email, String password, String gender,
            List<Integer> followers, List<Integer> followings) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.followers = followers;
    this.followings = followings;
}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Integer> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}

	public List<Integer> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Integer> followings) {
		this.followings = followings;
	}

	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id) {
         this.id = id;		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Post> getSavedPost()
	{
		return savedPost;
	}
	
	public void setSavedPost(List<Post> savedPost)
	{
	     this.savedPost = savedPost;
	}
	
}
