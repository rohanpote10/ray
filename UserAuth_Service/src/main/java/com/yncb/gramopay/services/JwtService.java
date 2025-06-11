package com.yncb.gramopay.services;

import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import com.yncb.gramopay.security.CustomUserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {

	String extractUsername(String token);

	<T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	String generateToken(CustomUserDetails userDetails);

	String generateToken(Map<String, Object> extraClaims, CustomUserDetails userDetails);

	long getExpirationTime();

	boolean isTokenValid(String token, CustomUserDetails userDetails);

	String extractTokenFromRequest(HttpServletRequest request);
}
