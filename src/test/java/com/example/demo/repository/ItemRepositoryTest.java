package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
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
		item.setStatus("UNREGISTERED");
		item.setName("삼성 노트북");
		item.setTitle("삼성 노트북 A100");
		item.setContent("2019년형 노트북 입니다");
		item.setPrice(900000);
		item.setBrandName("삼성");
		item.setRegisteredAt(LocalDateTime.now());
		item.setCreatedAt(LocalDateTime.now());
		item.setCreatedBy("Partner01");
		item.setPartnerId(1L);
		
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
