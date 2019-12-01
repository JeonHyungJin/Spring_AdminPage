package com.example.demo.model.network.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerApiResponse {
	private Long id;
	private String name;
	private String status;
	private String address;
	private String callCenter;
	private String partnerNumber;
	private String businessNumber;
	private String ceoName;
	private LocalDateTime registererdAt;
	private LocalDateTime unregistederdAt;
	private Long categoryId;
}
