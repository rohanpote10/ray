package com.yncb.gramopay.entities;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yncb.gramopay.enums.RolesEnum;

import lombok.Data;

@Data
@Entity
@Table(name="rolesdb")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Enumerated(EnumType.STRING)
	private RolesEnum roleType;
	
	private String roleDescription;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "role") 
	private List<User> users;

}
