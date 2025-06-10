package com.expo.blogapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="rolesDB")
public class Role {

	@Id
	private int roleId;
	private String roleName;
}
