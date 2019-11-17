package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
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
		orderDetail.setStatus("WAITING");
		orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
		orderDetail.setQuantity(1);
		orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
		orderDetail.setOrderGroupId(1L);
		orderDetail.setItemId(1L);
		orderDetail.setCreatedAt(LocalDateTime.now());
		orderDetail.setCreatedBy("AdminServer");
		
		OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
		
		assertNotNull(newOrderDetail);
		
	}
	
}
