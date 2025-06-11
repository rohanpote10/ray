package com.yncb.gramopay.services;

import com.yncb.gramopay.payloads.LoginRequest;
import com.yncb.gramopay.payloads.UserRequestDto;
import com.yncb.gramopay.responses.LoginResponse;
import com.yncb.gramopay.responses.UserProfileDto;

public interface AuthServices {

	 UserProfileDto registerUser(UserRequestDto regRequest);
	 LoginResponse authenticate(LoginRequest logRequest);
}
