package com.expo.blogapp.exceptionhandlers;

public class CategoryNotFoundException extends RuntimeException{
	
	public CategoryNotFoundException(String message){
		super(message);
	}

}
