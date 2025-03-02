package com.vedant.service;

import com.vedant.models.Post;

import java.util.List;

public interface PostService {

	Post createNewPost(Post post,Integer userId) throws Exception;
	
	String deletePost(Integer postId,Integer userId) throws Exception;
	
	List<Post> findPostByUserId(Integer userid);
	
	Post findPostById(Integer PostId) throws Exception;
	
	List<Post> findAllPost();
	
	Post savedPost(Integer postId, Integer userId) throws Exception;
	
	Post likePost(Integer postid, Integer userId) throws Exception;
}
