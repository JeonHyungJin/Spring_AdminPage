package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// select * from user where account = ?
	Optional<User> findByAccount(String account);
	Optional<User> findByEmail(String email);
	
	// select * from user where account =? and email = ?
	Optional<User> findByAccountAndEmail(String account, String email);
}
