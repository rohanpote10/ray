package com.expo.blogapp.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expo.blogapp.entities.Users;
import com.expo.blogapp.exceptionhandlers.ResourceNotFoundException;
import com.expo.blogapp.payloads.UsersDTO;
import com.expo.blogapp.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UsersDTO createUser(UsersDTO userDto) {
		Users user = this.dtoToUsers(userDto);
		return this.usersToDto(userRepo.save(user));
	}

	@Override
	public UsersDTO updateUser(UsersDTO userDto, Integer userId) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ID not found"));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		return this.usersToDto(userRepo.save(user));
	}

	@Override
	public UsersDTO getUserById(Integer userId) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ID not found"));
		return this.usersToDto(user);
	}

	@Override
	public List<UsersDTO> getAllUsers() {
		List<Users> usersList = userRepo.findAll();
		List<UsersDTO> dtoUserList = new ArrayList<UsersDTO>();
		for (Users user : usersList) {
			UsersDTO userDto = new UsersDTO();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			userDto.setAbout(user.getAbout());

			dtoUserList.add(userDto);
		}
		return dtoUserList;
	}

	@Override
	public int deleteUser(Integer userId) {
		int status = 0;
		Users user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User ID not found"));
		if (user != null) {
			this.userRepo.delete(user);
			status = 1;
		}
		return status;
	}

	private Users dtoToUsers(UsersDTO userDto) {

		Users user = mapper.map(userDto, Users.class);
// Traditional Setter/Getter method to map dto class t entity.
		//		Users user = new Users();
		//		user.setId(userDto.getId());
		//		user.setName(userDto.getName());
		//		user.setEmail(userDto.getEmail());
		//		user.setPassword(userDto.getPassword());
		//		user.setAbout(userDto.getAbout());
		return user;
	}

	private UsersDTO usersToDto(Users user) {
		UsersDTO userDto=mapper.map(user, UsersDTO.class);
// Traditional Setter/Getter method to map dto class t entity.
		//		UsersDTO userDto = new UsersDTO();
		//		userDto.setId(user.getId());
		//		userDto.setName(user.getName());
		//		userDto.setEmail(user.getEmail());
		//		userDto.setPassword(user.getPassword());
		//		userDto.setAbout(user.getAbout());

		return userDto;
	}
}
