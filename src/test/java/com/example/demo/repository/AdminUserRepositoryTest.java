package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.AdminUser;

public class AdminUserRepositoryTest extends StudyApplicationTests{

	@Autowired
	private AdminUserRepository adminUserRepository;
	
	
	@Test
	public void create() {
		AdminUser adminUser = new AdminUser();
		adminUser.setAccount("AdminUser01");
		adminUser.setPassword("AdminUser01");
		adminUser.setStatus("REGISTERED");
		adminUser.setRole("PARTNER");
		adminUser.setCreatedAt(LocalDateTime.now());
		adminUser.setCreatedBy("AdminServer");
		
		AdminUser newAdminUser = adminUserRepository.save(adminUser);
		
		assertNotNull(newAdminUser);
	}
	
}
