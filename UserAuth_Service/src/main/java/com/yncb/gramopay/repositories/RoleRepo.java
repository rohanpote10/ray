package com.yncb.gramopay.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yncb.gramopay.entities.Role;
import com.yncb.gramopay.enums.RolesEnum;

public interface RoleRepo extends JpaRepository<Role,Integer>{

	Optional<Role> findByRoleType(RolesEnum roleType);
}
