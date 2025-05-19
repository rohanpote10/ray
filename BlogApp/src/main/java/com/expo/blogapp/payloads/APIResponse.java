package com.expo.blogapp.payloads;

import lombok.Data;

@Data
public class APIResponse {
	

	public APIResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	private String message;
	private boolean status;
}
