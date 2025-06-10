package com.expo.blogapp.payloads;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.expo.blogapp.entities.Comment;

import lombok.Data;

@Data
public class PostDTO {

	private int postId;
	@NotEmpty(message="Title cannot be empty")
	private String title;
	@NotEmpty(message="Content cannot be empty")
	@Size(min=4,max=1000,message="Max length allowed 1000 characters")
	private String content;
	private String imageName;
	@CreationTimestamp
	private LocalDate addedDate;
	
	private CategoryDTO category;
	private UsersDTO user;
//	private Set<CommentDTO> comments	=new HashSet<>();
}
