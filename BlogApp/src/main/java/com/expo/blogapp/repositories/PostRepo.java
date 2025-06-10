package com.expo.blogapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.expo.blogapp.entities.Category;
import com.expo.blogapp.entities.Post;
import com.expo.blogapp.entities.Users;
import com.expo.blogapp.payloads.PostDTO;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(Users user);
	List<Post> findByCategory(Category category);
	Page<Post> findByCategory(Category category,Pageable pageable);
	Page<Post> findByUser(Users user,Pageable pageable);
	
	List<Post> findByTitleContaining(String title);
}
