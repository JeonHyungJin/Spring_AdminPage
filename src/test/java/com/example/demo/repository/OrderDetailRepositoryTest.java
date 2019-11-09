package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.OrderDetail;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Test
	public void create() {
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderAt(LocalDateTime.now());
//		orderDetail.setUserId(1L);
//		orderDetail.setItemId(1L);
		
		OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
		
		assertNotNull(newOrderDetail);
		
	}
	
}
