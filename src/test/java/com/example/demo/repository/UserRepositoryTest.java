package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.User;

public class UserRepositoryTest extends StudyApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void create() {
		String account = "Test01";
		String password = "Test01";
		String status = "REGISTERED";
		String email = "Test01@gmail.com";
		String phoneNumber = "010-1111-2222";
		LocalDateTime registeredAt = LocalDateTime.now();
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";

		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setStatus(status);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRegisteredAt(registeredAt);
		user.setCreatedAt(createdAt);
		user.setCreatedBy(createdBy);

		User newUser = userRepository.save(user);

		assertNotNull(newUser);

	}

	@Test
	@Transactional
	public void read() {
		User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

		user.getOrderGroupList().stream().forEach(orderGroup -> {

			System.out.println("----------주문묶음----------");
			System.out.println(orderGroup.getTotalPrice());
			System.out.println(orderGroup.getRevAddress());
			System.out.println(orderGroup.getRevName());
			System.out.println(orderGroup.getTotalQuantity());

			System.out.println("----------주문상세----------");

			orderGroup.getOrderDetailList().forEach(OrderDetail -> {
				
				System.out.println(OrderDetail.getItem().getPartner().getName());
				System.out.println(OrderDetail.getItem().getPartner().getCategory().getTitle());
				System.out.println(OrderDetail.getItem().getName());
				System.out.println(OrderDetail.getItem().getPartner().getCallCenter());
				System.out.println(OrderDetail.getStatus());
				System.out.println(OrderDetail.getArrivalDate());
				
				
			});

		});

		assertNotNull(user);

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
