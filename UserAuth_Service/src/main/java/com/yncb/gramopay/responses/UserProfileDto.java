package com.yncb.gramopay.responses;

import lombok.Data;

@Data
public class UserProfileDto {
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private long contact;
	private String password;
}
