package com.expo.blogapp.services;

import java.util.List;

import com.expo.blogapp.entities.Post;
import com.expo.blogapp.payloads.PostDTO;

public interface PostServices {

	PostDTO createPost(PostDTO postDto,Integer userId,Integer categoryId);
	PostDTO updatePost(PostDTO postDto,Integer postId);
	int deletePost(Integer postId);
	List<PostDTO> getAllPost();
	PostDTO getPost(Integer postId);
	List<PostDTO>getPostsByCategory(Integer categoryId);
	List<PostDTO>getPostsByUser(Integer userId);
}
