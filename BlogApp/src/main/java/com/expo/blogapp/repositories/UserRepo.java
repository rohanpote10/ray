package com.expo.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expo.blogapp.entities.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

}
