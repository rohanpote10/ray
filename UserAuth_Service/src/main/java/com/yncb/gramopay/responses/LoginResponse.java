package com.yncb.gramopay.responses;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class LoginResponse {

	private int userId;
	private String token;
	private String expiresAt;
}
