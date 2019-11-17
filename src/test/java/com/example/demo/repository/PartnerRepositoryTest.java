package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.entity.Partner;

public class PartnerRepositoryTest extends StudyApplicationTests {

	@Autowired
	private PartnerRepository partnerRepository;

	@Test
	public void create() {
		String name = "Partner01";
		String status = "REGISTERED";
		String address = "서울시 강남구";
		String callCenter = "070-1111-2222";
		String partnerNumber = "010-1111-2222";
		String businessNumber = "1234567890123";
		String ceoName = "홍길동";
		LocalDateTime registeredAt = LocalDateTime.now();
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		Long categoryId = 1L;

		Partner partner = new Partner();
		partner.setName(name);
		partner.setStatus(status);
		partner.setAddress(address);
		partner.setCallCenter(callCenter);
		partner.setPartnerNumber(partnerNumber);
		partner.setBusinessNumber(businessNumber);
		partner.setCeoName(ceoName);
		partner.setRegisteredAt(registeredAt);
		partner.setCreatedAt(createdAt);
		partner.setCreatedBy(createdBy);
//		partner.setCategoryId(categoryId);

		Partner newPartner = partnerRepository.save(partner);
		
		assertNotNull(newPartner);
		assertEquals(newPartner.getName(), name);
	
	}
}
