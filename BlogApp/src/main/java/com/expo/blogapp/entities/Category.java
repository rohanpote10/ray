package com.expo.blogapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="categoryDB")
@Data
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Post> postsList=new ArrayList<>();
}
