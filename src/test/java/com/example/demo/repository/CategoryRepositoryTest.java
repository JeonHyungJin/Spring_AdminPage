package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.Category;

public class CategoryRepositoryTest extends StudyApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void create() {
		String type = "COMPUTER";
		String title = "컴퓨터";
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
		Category category = new Category();
		category.setType(type);
		category.setTitle(title);
		category.setCreatedAt(createdAt);
		category.setCreatedBy(createdBy);
	
		Category newCategory = categoryRepository.save(category);
		
		assertNotNull(newCategory);
		assertEquals(newCategory.getType(), type);
		assertEquals(newCategory.getTitle(), title);
	}

	@Test
	public void read() {
		
		String type = "COMPUTER";
		
		Optional<Category> optionalCategory = categoryRepository.findByType(type);
		
		//select * from category where type = ?
		
		optionalCategory.ifPresent(c -> {
			
			assertEquals(c.getType(), type);
			
			System.out.println(c.getId());
			System.out.println(c.getType());
			System.out.println(c.getTitle());
		});

	}
}
