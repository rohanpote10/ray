package com.yncb.gramopay.controllers;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yncb.gramopay.payloads.LoginRequest;
import com.yncb.gramopay.payloads.UserRequestDto;
import com.yncb.gramopay.responses.LoginResponse;
import com.yncb.gramopay.responses.UserProfileDto;
import com.yncb.gramopay.services.AuthServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Tag(name = "UserAuthentication_API's", description = "All API's are related to User Authentication")
@RestController
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {

	@Autowired
	private AuthServices authService;

	@Operation(summary = "Register a new User", description = "Registers new user with provided details")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "User created successfully"),
			@ApiResponse(responseCode = "302", description = "User already exist") })
	@PostMapping("register")
	public ResponseEntity<UserProfileDto> signUpUser(@Valid @RequestBody UserRequestDto regRequest) {
		log.debug("Register Request: " + regRequest);
		return new ResponseEntity(authService.registerUser(regRequest), HttpStatus.CREATED);
	}
	
	@Operation(summary = "User Login", description = "Token creation if valid login details entered")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "User logged in and token created"),
			@ApiResponse(responseCode = "401", description = "Unauthorized - Invalid Credentials") })
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> signInUser(@Valid @RequestBody LoginRequest logRequest){
		log.debug("authenticated( {} )"+logRequest.getEmail());
		return new ResponseEntity(authService.authenticate(logRequest),HttpStatus.ACCEPTED);
	}

}
