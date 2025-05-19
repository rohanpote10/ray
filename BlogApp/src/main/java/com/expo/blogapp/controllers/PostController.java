package com.expo.blogapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expo.blogapp.entities.Post;
import com.expo.blogapp.payloads.PostDTO;
import com.expo.blogapp.services.PostServices;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostServices postService;

	@PostMapping("/users/{userId}/category/{categoryId}")
	public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		return new ResponseEntity(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
	}

	@GetMapping("/posts/category/{categoryId}")
	public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer categoryId) {

		return new ResponseEntity(postService.getPostsByCategory(categoryId), HttpStatus.OK);
	}
}
