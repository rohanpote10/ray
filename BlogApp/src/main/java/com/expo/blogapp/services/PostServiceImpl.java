package com.expo.blogapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expo.blogapp.entities.Category;
import com.expo.blogapp.entities.Post;
import com.expo.blogapp.entities.Users;
import com.expo.blogapp.exceptionhandlers.CategoryNotFoundException;
import com.expo.blogapp.exceptionhandlers.ResourceNotFoundException;
import com.expo.blogapp.payloads.PostDTO;
import com.expo.blogapp.repositories.CategoriesRepo;
import com.expo.blogapp.repositories.PostRepo;
import com.expo.blogapp.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostServices {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoriesRepo categoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId) {
		Users user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Id doesn't exist !!"));
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist !!"));

		Post post = mapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setUser(user);
		post.setCategory(category);
		postRepo.save(post);

		return mapper.map(post, PostDTO.class);
	}

	@Override
	public PostDTO updatePost(PostDTO postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePost(Integer postId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PostDTO> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO getPost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist !!"));
		List<Post> posts = postRepo.findByCategory(category);
		List<PostDTO> postByCategory=posts.stream().map((post) -> mapper.map(post, PostDTO.class)).collect(Collectors.toList());
		return postByCategory;
	}

	@Override
	public List<PostDTO> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
