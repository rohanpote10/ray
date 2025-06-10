package com.expo.blogapp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.expo.blogapp.config.AppConstants;
import com.expo.blogapp.entities.Role;
import com.expo.blogapp.repositories.RolesRepo;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolesRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("yash@123"));
		System.out.println(passwordEncoder.encode("rohan@123"));
		
		try {
			Role adminRole =  new Role();
			adminRole.setRoleId(AppConstants.ADMIN_USER);
			adminRole.setRoleName("ROLE_ADMIN");
			
			Role userRole=new Role();
			userRole.setRoleId(AppConstants.NORMAL_USER);
			userRole.setRoleName("ROLE_NORMAL");
			
			List <Role> roleList=new ArrayList<Role>();
			roleList.add(adminRole);
			roleList.add(userRole);
			
			List<Role> rolesList = roleRepo.saveAll(roleList);
			
			rolesList.forEach(role -> System.out.println(role.getRoleName()) );
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
