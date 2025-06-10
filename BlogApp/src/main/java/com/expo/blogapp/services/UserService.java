package com.expo.blogapp.services;

import java.util.List;

import com.expo.blogapp.payloads.UsersDTO;
public interface UserService {

	UsersDTO registerNewUser(UsersDTO userDto);
	UsersDTO createUser(UsersDTO user);
	UsersDTO updateUser(UsersDTO user, Integer userId);
	UsersDTO getUserById(Integer userId);
	List<UsersDTO> getAllUsers();
	int deleteUser(Integer userId); 
}
