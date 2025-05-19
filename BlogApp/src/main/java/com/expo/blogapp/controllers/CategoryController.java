package com.expo.blogapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.expo.blogapp.payloads.CategoryDTO;
import com.expo.blogapp.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDto) {
		return new ResponseEntity(categoryService.addCategory(categoryDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDto,@PathVariable Integer id) {
		return new ResponseEntity(categoryService.updateCategory(categoryDto, id), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
		if (categoryService.deleteCategory(id) == 1)
			return ResponseEntity.ok("Category deleted successfully !!");
		else
			return new ResponseEntity("Unable to delete category", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer id) {
		return ResponseEntity.ok(categoryService.getCategory(id));
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
}
