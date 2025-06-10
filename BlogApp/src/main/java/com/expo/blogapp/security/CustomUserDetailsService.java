package com.expo.blogapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expo.blogapp.entities.Users;
import com.expo.blogapp.exceptionhandlers.ResourceNotFoundException;
import com.expo.blogapp.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("Username doesn't exits !!!")); 
		return user;
	}

	
}
