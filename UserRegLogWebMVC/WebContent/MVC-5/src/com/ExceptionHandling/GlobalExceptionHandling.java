package com.ExceptionHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullpointer(NullPointerException ne) {
//		System.out.println("First nullpointer handle");
		System.out.println("Global null Handling");
		System.out.println(ne.getMessage());
		return "error";
	}
	
	@ExceptionHandler(value = CustomeNullHandling.class)
	public String handleNullpointer(CustomeNullHandling ne) {
//		System.out.println("First nullpointer handle");
		System.out.println("Global Custome-null Handling");
		System.out.println(ne.getMessage());
		return "error";
	}
}
