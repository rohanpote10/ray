package com.yncb.gramopay.entities;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.yncb.gramopay.enums.KycStatusEnum;
import com.yncb.gramopay.enums.UserStatusEnum;
import com.yncb.gramopay.security.CustomUserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
@NoArgsConstructor
@ToString
@Table(name = "usersdb")
public class User implements CustomUserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String username;

	private String password;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(length = 10)
	private String contact;

	@Column(nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	private KycStatusEnum kycStatus;

	@Enumerated(EnumType.STRING)
	private UserStatusEnum userStatus;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
	private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.debug("getAuthorities()");
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleType().toString());
		return Collections.singletonList(authority);
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override 
	public boolean isAccountNonExpired() {
		log.debug("isAccountNonExpired()");
		return true;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAccountNonLocked() {
		log.debug("isAccountNonLocked()");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		log.debug("isCredentialsNonExpired()");
		return true;
	}

	@Override
	public boolean isEnabled() {
		log.debug("isEnabled()");
		return true;
	}
}
