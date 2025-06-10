package com.expo.blogapp.services;

import com.expo.blogapp.entities.Users;
import com.expo.blogapp.payloads.CommentDTO;

public interface CommentService {

	CommentDTO createComment(CommentDTO commentDto,Integer postId,Integer userId);
	void deleteComment(Integer commentId);
}
