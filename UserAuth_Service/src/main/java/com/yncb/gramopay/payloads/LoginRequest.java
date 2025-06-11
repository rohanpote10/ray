package com.yncb.gramopay.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank(message = "Password cannot be empty")
	private String password;
}
