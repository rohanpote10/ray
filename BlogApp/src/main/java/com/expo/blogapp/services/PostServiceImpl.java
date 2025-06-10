package com.expo.blogapp.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.expo.blogapp.payloads.PostResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.expo.blogapp.entities.Category;
import com.expo.blogapp.entities.Post;
import com.expo.blogapp.entities.Users;
import com.expo.blogapp.exceptionhandlers.CategoryNotFoundException;
import com.expo.blogapp.exceptionhandlers.ResourceNotFoundException;
import com.expo.blogapp.payloads.CommentDTO;
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
		Post post=postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ID not found"));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		postRepo.save(post);
		
		return mapper.map(post,PostDTO.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post doesn't exist !!"));
		postRepo.delete(post);
	}
	


	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy) { 
		
//		Only for pagination
// 	Pageable pagePost=PageRequest.of(pageNumber, pageSize);
//		For pagination and sorting -->By default ascending sorting is performed
		Pageable pagePost=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
		
//		For pagination and sorting -->By default ascending sorting is performed
//		Pageable pagePost=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).descending());
		Page<Post> postList=postRepo.findAll(pagePost);
		
//		List<Post>postList=postRepo.findAll();
		List<PostDTO> postDtoList = postList.stream().map((post) -> mapper.map(post, PostDTO.class)).collect(Collectors.toList());
		PostResponse postResponse=new PostResponse();
		postResponse.setPostList(postDtoList);
		postResponse.setPageSize(postList.getSize());
		postResponse.setPageNumber(postList.getNumber());
		postResponse.setTotalElements(postList.getTotalElements());
		postResponse.setTotalPages(postList.getTotalPages());
		postResponse.setLastPage(postList.isLast());
		return postResponse;
	}

	@Override
	public PostDTO getPost(Integer postId) { 
		Post post=postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post unavailable !!"));
		return mapper.map(post, PostDTO.class);
	}

	@Override
	public PostResponse getPostsByCategory(Integer pageNumber,Integer pageSize, Integer categoryId) { 
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist !!"));
//		List<Post> posts = postRepo.findByCategory(category);
		
		Pageable pagePost=PageRequest.of(pageNumber, pageSize);
		Page<Post> postList=postRepo.findByCategory(category, pagePost);
		PostResponse response=new PostResponse();
		List<PostDTO> postByCategory=postList.stream().map((post) -> mapper.map(post, PostDTO.class)).collect(Collectors.toList());
		response.setPostList(postByCategory);
		response.setPageNumber(postList.getNumber());
		response.setPageSize(postList.getSize());
		response.setTotalElements(postList.getTotalElements());
		response.setTotalPages(postList.getTotalPages());
		response.setLastPage(postList.isLast());
		return response;
	}

	@Override
	public PostResponse getPostsByUser(Integer pageNumber,Integer pageSize,Integer userId) {
		Users user=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist !! "));
//		List<Post> posts=postRepo.findByUser(user);
		Pageable postPage=PageRequest.of(pageNumber, pageSize);
		Page<Post> pagedPostList=postRepo.findByUser(user, postPage);
		List<PostDTO>postList=pagedPostList.stream().map((post) -> mapper.map(post, PostDTO.class)).collect(Collectors.toList());
		PostResponse response=new PostResponse();
		response.setPostList(postList);
		response.setPageNumber(pagedPostList.getNumber());
		response.setPageSize(pagedPostList.getSize());
		response.setTotalElements(pagedPostList.getTotalElements());
		response.setTotalPages(pagedPostList.getTotalPages());
		response.setLastPage(pagedPostList.isLast());
		return response;
	}
	
	@Override
	public List<PostDTO> searchPostByTitle(String title){
		
		List<Post> postList=postRepo.findByTitleContaining(title);
		List<PostDTO> postDtoList=postList.stream().map((post) -> mapper.map(post,PostDTO.class)).collect(Collectors.toList());
		return postDtoList;
	}

}
