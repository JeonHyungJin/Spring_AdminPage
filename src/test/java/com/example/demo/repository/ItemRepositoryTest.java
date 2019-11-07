package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.Item;

public class ItemRepositoryTest extends StudyApplicationTests {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void create() {

		Item item = new Item();
		item.setName("노트북");
		item.setPrice(100000);
		item.setContent("삼성 노트북");

		Item newItem = itemRepository.save(item);

		assertNotNull(newItem);
	}

	@Test
	public void read() {
		Long id = 1L;
		
		Optional<Item> item = itemRepository.findById(id);
	
		assertTrue(item.isPresent());
		
	}

}
