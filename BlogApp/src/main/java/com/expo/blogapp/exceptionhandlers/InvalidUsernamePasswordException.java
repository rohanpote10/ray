package com.expo.blogapp.exceptionhandlers;

public class InvalidUsernamePasswordException extends RuntimeException {
	public InvalidUsernamePasswordException(String message) {
		super(message);
	}
}
