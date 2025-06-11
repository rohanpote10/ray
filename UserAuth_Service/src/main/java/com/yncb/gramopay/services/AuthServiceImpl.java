package com.yncb.gramopay.services;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yncb.gramopay.entities.Role;
import com.yncb.gramopay.entities.User;
import com.yncb.gramopay.enums.KycStatusEnum;
import com.yncb.gramopay.enums.RolesEnum;
import com.yncb.gramopay.enums.UserStatusEnum;
import com.yncb.gramopay.exceptions.ResourceFoundException;
import com.yncb.gramopay.payloads.LoginRequest;
import com.yncb.gramopay.payloads.UserRequestDto;
import com.yncb.gramopay.repositories.RoleRepo;
import com.yncb.gramopay.repositories.UserAuthRepo;
import com.yncb.gramopay.responses.LoginResponse;
import com.yncb.gramopay.responses.UserProfileDto;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Builder
public class AuthServiceImpl implements AuthServices {

	@Autowired
	private UserAuthRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserProfileDto registerUser(UserRequestDto regRequest) {
		log.info("User registration details: " + regRequest);
		User existingUser = userRepo.findByEmail(regRequest.getEmail()).orElse(null);
		if (existingUser != null) {
			throw new ResourceFoundException("Email ID already exist !!!");
		}
		User user = mapper.map(regRequest, User.class);
		Role role = roleRepo.findByRoleType(RolesEnum.USER).get();
		user.setRole(role);
		user.setPassword(encoder.encode(regRequest.getPassword()));
		user.setKycStatus(KycStatusEnum.PENDING);
		user.setUserStatus(UserStatusEnum.ACTIVE);
		User savedUser = userRepo.save(user);
		return mapper.map(savedUser, UserProfileDto.class);
	}

	@Override
	public LoginResponse authenticate(LoginRequest logRequest) {
		authManager
				.authenticate(new UsernamePasswordAuthenticationToken(logRequest.getEmail(), logRequest.getPassword()));
		User authenticatedUser = userRepo.findByEmail(logRequest.getEmail())
				.orElseThrow(() -> new UsernameNotFoundException(logRequest.getEmail()));

//		authenticatedUser.setBlacklisted(false); 
		Instant currentDate = Instant.now();
		User updatedUser = userRepo.save(authenticatedUser);
		String jwtToken = jwtService.generateToken(updatedUser);
		return LoginResponse.builder().userId(updatedUser.getId()).token(jwtToken)
				.expiresAt(currentDate.plusMillis(jwtService.getExpirationTime()).toString()).build();
	}

}
