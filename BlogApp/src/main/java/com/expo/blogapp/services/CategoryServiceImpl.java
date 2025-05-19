package com.expo.blogapp.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expo.blogapp.entities.Category;
import com.expo.blogapp.exceptionhandlers.CategoryNotFoundException;
import com.expo.blogapp.payloads.CategoryDTO;
import com.expo.blogapp.repositories.CategoriesRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoriesRepo categoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDto) {
		Category category = mapper.map(categoryDto, Category.class);
		return mapper.map(categoryRepo.save(category), CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer id) {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist !!"));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		categoryRepo.save(category);
		return mapper.map(categoryRepo.save(category), CategoryDTO.class);
	}

	@Override
	public int deleteCategory(Integer id) {
		int status = 0;
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist !!"));
		if (category != null) {
			categoryRepo.delete(category);
			status = 1;
		}
		return status;
	}

	@Override
	public CategoryDTO getCategory(Integer id) {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category doesn't exist !!"));
		return mapper.map(category, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categoryList = categoryRepo.findAll();
		List<CategoryDTO> categoryDtoList = categoryList.stream()
				.map((category) -> mapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
		return categoryDtoList;
	}

}
