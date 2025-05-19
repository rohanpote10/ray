package com.expo.blogapp.exceptionhandlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFound(ResourceNotFoundException msg) {
		return new ResponseEntity(msg.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValid(MethodArgumentNotValidException msg) {
		Map<String, String> response = new HashMap<>();
		msg.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> categoryNotFound(CategoryNotFoundException msg){
		return new ResponseEntity(msg.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> httpMethodNotSupported(HttpRequestMethodNotSupportedException msg){
		return new ResponseEntity(msg.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
