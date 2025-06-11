package com.yncb.gramopay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.yncb.gramopay.security.JwtAuthFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationProvider authProvider;
	
	@Autowired
	private JwtAuthFilter authFilter;
	
	public static final String[] PUBLIC_URLS = { "/api/v1/auth/**", "/v3/api-docs", "/v3/api-docs",
			"/swagger-resources/**", "/swagger-ui/**", "/webjars/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.csrf()
	.disable()
	.authorizeRequests()
	.antMatchers(PUBLIC_URLS).permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.sessionManagement()					// Token Related code
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)    // Token Related code
	.and()
	.authenticationProvider(authProvider).addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
	
	}

}
