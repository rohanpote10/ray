package com.expo.blogapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expo.blogapp.exceptionhandlers.InvalidUsernamePasswordException;
import com.expo.blogapp.payloads.UsersDTO;
import com.expo.blogapp.security.JwtAuthRequest;
import com.expo.blogapp.security.JwtAuthResponse;
import com.expo.blogapp.security.JwtTokenHelper;
import com.expo.blogapp.services.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private JwtTokenHelper helper;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		String token = helper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken unamePswdAuthToken = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			authManager.authenticate(unamePswdAuthToken);
		} catch (BadCredentialsException msg) {
			throw new InvalidUsernamePasswordException("Invalid username or password !!");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<UsersDTO> registerUser(@RequestBody UsersDTO userDto) {
		return new ResponseEntity(userService.registerNewUser(userDto), HttpStatus.CREATED);
	}
}
