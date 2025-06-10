package com.expo.blogapp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
//4th Step

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenHelper tokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//		Get Token 
		String requestToken = request.getHeader("Authorization");
		System.out.println("Token: "+requestToken);

		String username = null;
		String token = null;

		if (requestToken != null && requestToken.startsWith("Bearer")) {
			token = requestToken.substring(7);
			try {
				username = this.tokenHelper.getUsernameFromToken(token);
			} catch (IllegalArgumentException msg) {
				System.out.println("Unable to get Token");
			} catch (ExpiredJwtException msg) {
				System.out.println("Token has expired");
			} catch (MalformedJwtException msg) {
				System.out.println("Invalid Token");
			}
		} else {
			System.out.println("JWT token does not begin with Bearer");
		}

		// now we have got the Token, we will validate it now
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (tokenHelper.validateToken(token, userDetails)) {

//			Everything is fine, now we need to do authentication
				UsernamePasswordAuthenticationToken unamePswdAuthToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				unamePswdAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(unamePswdAuthToken);
			} else {
				System.out.println("Invalid JWT Token");
			}
		} else {
			System.out.println("Username is null or Context is not null");
		}

		filterChain.doFilter(request, response);
	}

}
