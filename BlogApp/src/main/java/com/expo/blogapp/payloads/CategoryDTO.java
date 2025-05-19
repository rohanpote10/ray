package com.expo.blogapp.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoryDTO {

	private int categoryId;
	@NotEmpty
	@Size(min=3, message="Category Title too small")
	private String categoryTitle;
	@NotEmpty
	@Size(max=100,message="Too lengthy category description")
	private String categoryDescription;
}
