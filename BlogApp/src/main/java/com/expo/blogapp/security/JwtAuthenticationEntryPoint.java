package com.expo.blogapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//2nd Step
@Component
public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint{
// 	This commence method will be executed when any unauthorised person will try to access our API's
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED," Access Denied !!");
	}

}
