package com.expo.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expo.blogapp.entities.Category;

public interface CategoriesRepo extends JpaRepository<Category,Integer>{

}
