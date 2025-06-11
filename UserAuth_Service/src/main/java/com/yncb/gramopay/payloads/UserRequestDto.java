package com.yncb.gramopay.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
public class UserRequestDto {

	@NotBlank(message = "Username cannot be empty")
	@Pattern(regexp = "^[a-zA-Z0-9@]{3,15}$", message = "Username must be 3-15 alphanumeric characters")
	@JsonProperty(value = "username")
	private String username;
	
	@NotBlank(message = "Email cannot be empty")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
	@JsonProperty(value = "email")
	private String email;
	
	@NotBlank(message = "Name cannot be empty")
	@JsonProperty(value = "firstName")
	private String firstName;
	
	@JsonProperty(value = "lastName")
	private String lastName;
	
	@NotEmpty(message = "Contact cannot be empty")
	@JsonProperty(value = "contact")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid contact number")
	private String contact;
	 
	@NotBlank(message = "Password cannot be empty")
	@Size(min = 3, max = 10, message = "Password length should be greater than 3 and less than 10")
	@JsonProperty(value = "password")
	private String password;
}
