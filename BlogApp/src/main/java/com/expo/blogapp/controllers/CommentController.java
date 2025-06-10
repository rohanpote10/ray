package com.expo.blogapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expo.blogapp.payloads.CommentDTO;
import com.expo.blogapp.services.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/create/post/{postId}/user/{userId}")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDto, @PathVariable Integer postId,
			@PathVariable Integer userId) {
		return new ResponseEntity(commentService.createComment(commentDto, postId, userId), HttpStatus.CREATED);
	}
}
