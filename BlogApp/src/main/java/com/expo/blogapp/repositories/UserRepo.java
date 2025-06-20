package com.expo.blogapp.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expo.blogapp.entities.Users;
import com.expo.blogapp.payloads.PostDTO;
@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{


	Optional<Users> findByEmail(String username);
}
