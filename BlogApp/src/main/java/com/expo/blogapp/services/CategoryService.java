package com.expo.blogapp.services;

import java.util.List;

import com.expo.blogapp.payloads.CategoryDTO;

public interface CategoryService {

	CategoryDTO addCategory(CategoryDTO categoryDto);
	CategoryDTO updateCategory(CategoryDTO categoryDto,Integer id);
	public int deleteCategory(Integer id);
	CategoryDTO getCategory(Integer id);
	List<CategoryDTO> getAllCategories();
}
