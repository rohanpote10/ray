package com.expo.blogapp.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expo.blogapp.payloads.APIResponse;
import com.expo.blogapp.payloads.UsersDTO;
import com.expo.blogapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UsersDTO> createUser(@Valid @RequestBody UsersDTO userDto) {
		return new ResponseEntity(userService.createUser(userDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@Valid @RequestBody UsersDTO userDto, @PathVariable Integer id) {
		if (userService.updateUser(userDto, id) != null)
			return new ResponseEntity("User updated successfully !!!", HttpStatus.OK);
		else
			return new ResponseEntity("User modification failed !!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> deleteUser(@PathVariable Integer id) {
		if (userService.deleteUser(id) == 1)
			return ResponseEntity.ok((new APIResponse("User deleted successfully !!", true)));
		else
			return ResponseEntity.ok((new APIResponse("User deletion failed !!", true)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> getUser(@PathVariable Integer id){
		return new ResponseEntity(userService.getUserById(id),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<UsersDTO> getAllUsers(){
		return new ResponseEntity(userService.getAllUsers(),HttpStatus.OK);
	}
}
