package com.expo.blogapp.services;

import java.util.List;

import com.expo.blogapp.entities.Post;
import com.expo.blogapp.payloads.PostDTO;
import com.expo.blogapp.payloads.PostResponse;

public interface PostServices {

	PostDTO createPost(PostDTO postDto,Integer userId,Integer categoryId);
	PostDTO updatePost(PostDTO postDto,Integer postId);
	void deletePost(Integer postId);
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);
	PostDTO getPost(Integer postId);
	PostResponse getPostsByCategory(Integer pageNumber,Integer pageSize,Integer categoryId);
	PostResponse getPostsByUser(Integer pageNumber,Integer pageSize,Integer userId);
	List<PostDTO> searchPostByTitle(String title);
}
