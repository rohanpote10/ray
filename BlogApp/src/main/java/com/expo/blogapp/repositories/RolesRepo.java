package com.expo.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expo.blogapp.entities.Role;

public interface RolesRepo extends JpaRepository<Role, Integer>{

}
