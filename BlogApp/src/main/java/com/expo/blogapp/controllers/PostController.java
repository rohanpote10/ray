package com.expo.blogapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expo.blogapp.config.AppConstants;
import com.expo.blogapp.entities.Post;
import com.expo.blogapp.payloads.APIResponse;
import com.expo.blogapp.payloads.PostDTO;
import com.expo.blogapp.payloads.PostResponse;
import com.expo.blogapp.services.PostServices;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostServices postService;

	@PostMapping("/users/{userId}/category/{categoryId}")
	public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		return new ResponseEntity(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<PostResponse> getPostsByCategory(@PathVariable Integer categoryId,
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
		return new ResponseEntity(postService.getPostsByCategory(pageNumber, pageSize, categoryId), HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<PostResponse> getPostsByUser(@PathVariable Integer userId,
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
		return new ResponseEntity(postService.getPostsByUser(pageNumber, pageSize, userId), HttpStatus.OK);
	}

	@GetMapping("/get/{postId}")
	public ResponseEntity<PostDTO> getPost(@PathVariable Integer postId) {
		return new ResponseEntity(postService.getPost(postId), HttpStatus.OK);
	}

	@GetMapping("/allposts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy) {
		return new ResponseEntity(postService.getAllPost(pageNumber, pageSize, sortBy), HttpStatus.OK);
	}

	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDto, @PathVariable Integer postId) {
		return new ResponseEntity(postService.updatePost(postDto, postId), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{postId}")
	public APIResponse deletePost(@PathVariable Integer postId) {
		postService.deletePost(postId);
		return new APIResponse("Post deleted successfully !!", true);
	}

	@GetMapping("/search/{title}")
	public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable String title) {
		return new ResponseEntity(postService.searchPostByTitle(title), HttpStatus.OK);
	}
}
