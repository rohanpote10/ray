package com.expo.blogapp.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expo.blogapp.entities.Comment;
import com.expo.blogapp.entities.Post;
import com.expo.blogapp.entities.Users;
import com.expo.blogapp.exceptionhandlers.ResourceNotFoundException;
import com.expo.blogapp.payloads.CommentDTO;
import com.expo.blogapp.repositories.CommentRepo;
import com.expo.blogapp.repositories.PostRepo;
import com.expo.blogapp.repositories.UserRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentDTO createComment(CommentDTO commentDto, Integer postId, Integer userId) {
		Users user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User doesn't exist !!"));
		Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post doesn't exist !!"));

		Comment comment = mapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		commentRepo.save(comment);

		return mapper.map(comment, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment ID doesn't exist !!"));
		commentRepo.delete(comment);
	}

}
