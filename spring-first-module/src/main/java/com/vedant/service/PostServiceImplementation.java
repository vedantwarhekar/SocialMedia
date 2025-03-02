package com.vedant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.vedant.models.Post;
import com.vedant.repository.PostRepository;

import com.vedant.models.User;
import com.vedant.repository.UserRepository;

import java.time.LocalDateTime;


@Service
public class PostServiceImplementation implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
		
		User user = userService.findById(userId);
		
		Post newPost = new Post();
		
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		newPost.setCreatedAt(LocalDateTime.now());
        newPost.setUser(user);
		
		return null;
	}

	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostById(postId);
		User user = userService.findById(userId);
		if(post.getUser().getId() != user.getId())
		{
			throw new Exception("Non-autorized Request");
		}
		postRepository.delete(post);
		return "Post deleted successfully";
	}

	@Override
	public List<Post> findPostByUserId(Integer userid) {
		return postRepository.findPostByUserId(userid);
	}

	@Override
	public Post findPostById(Integer postId) throws Exception {
		Optional<Post> opt = postRepository.findById(postId);
		if(opt.isEmpty())
		{
			throw new Exception("Post not found with this id:- "+postId);
		}
		return opt.get();
	}

	@Override
	public List<Post> findAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post savedPost(Integer postId, Integer userId) throws Exception{
		Post post = findPostById(postId);
		User user = userService.findById(userId);
		
		if(user.getSavedPost().contains(post))
		{
			user.getSavedPost().remove(post);
		}else {
			user.getSavedPost().add(post);
		}
		userRepository.save(user);
		return post;
	}

	@Override
	public Post likePost(Integer postid, Integer userId) throws Exception {
		
		Post post = findPostById(postid);
		User user = userService.findById(userId);
		
		if(post.getLiked().contains(user))
		{
			post.getLiked().remove(user);
		}
		else
		{
			post.getLiked().add(user);
		}
		return postRepository.save(post);
	}

}
