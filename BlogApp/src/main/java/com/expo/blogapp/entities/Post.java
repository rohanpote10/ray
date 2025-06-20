package com.expo.blogapp.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.expo.blogapp.payloads.CommentDTO;

import lombok.Data;

@Entity
@Table(name="postsDB")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	private String title;
	private String content;
	private String imageName;
	@CreationTimestamp
	private LocalDate addedDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
//	@OneToMany(mappedBy="post",cascade = CascadeType.ALL)
//	private Set<Comment> comments=new HashSet<>();
}
