package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.User;

public class UserRepositoryTest extends StudyApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void create() {
		User user = new User();
		user.setAccount("TestUser03");
		user.setEmail("TestUser03@gmail.com");
		user.setPhoneNumber("010-3333-3333");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("admin");

		User newUser = userRepository.save(user);
		System.out.println("newUser: " + newUser);

	}

	@Test
	public void read() {
		Optional<User> user = userRepository.findById(2L);
		
		user.ifPresent(selectUser -> {
			System.out.println("user : " + selectUser);
			System.out.println("email : " + selectUser.getEmail());
		});
	}

	@Test
	public void update() {
		Optional<User> user = userRepository.findById(2L);

		user.ifPresent(selectUser -> {
			selectUser.setAccount("pppp");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("updated method(");
	
			userRepository.save(selectUser);
		});
		
	}

	@Test
	@Transactional
	public void delete() {
		Optional<User> user = userRepository.findById(3L);
		
		assertTrue(user.isPresent());
		
		user.ifPresent(selectUser -> {
			userRepository.delete(selectUser);
		});
		
		Optional<User> deleteUser = userRepository.findById(3L);
		
		assertFalse(deleteUser.isPresent());
		
	}
}
