package com.expo.blogapp.exceptionhandlers;

public class ResourceNotFoundException extends RuntimeException{
	
//	String resourceName;
//	String fieldName;
//	long fieldValue;
//	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
//		super(String.format("%s  not found with %s  : %l", resourceName,fieldName,fieldValue));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldValue = fieldValue;
//	}
	
	public ResourceNotFoundException(String message) {
		super(message);
		
	}
}
