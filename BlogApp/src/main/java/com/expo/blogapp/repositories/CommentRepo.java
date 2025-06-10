package com.expo.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expo.blogapp.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
