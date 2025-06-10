package com.expo.blogapp.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsersDTO {

	private int id;
	@NotEmpty
	@Size(min=4,message="Name length too small")
	private String name;
	@NotEmpty
	@Email(message="Invalid Email ID !!")
	private String email;
	@NotEmpty
	@Size(min=3,max=10, message="Password length should be greater than 3 and less than 10")
	private String password;
	@NotEmpty
	private String about;
	
	private Set<RolesDTO> role=new HashSet<>();
}
