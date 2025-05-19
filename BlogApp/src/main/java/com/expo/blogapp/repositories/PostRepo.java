package com.expo.blogapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expo.blogapp.entities.Category;
import com.expo.blogapp.entities.Post;
import com.expo.blogapp.entities.Users;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(Users user);
	List<Post> findByCategory(Category category);
}
