package com.yncb.gramopay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yncb.gramopay.entities.User;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public interface UserAuthRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
}
