package com.yncb.gramopay.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionManager {

	@ExceptionHandler(ResourceFoundException.class)
	public ResponseEntity<String> resourceNotFound(ResourceFoundException msg) {
		return new ResponseEntity(msg.getMessage(), HttpStatus.FOUND);
	}

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

}
