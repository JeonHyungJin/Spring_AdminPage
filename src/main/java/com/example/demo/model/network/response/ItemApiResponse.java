package com.example.demo.model.network.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemApiResponse {

	private Long id;
	private String status;
	private String name;
	private String title;
	private String content;
	private BigDecimal price;
	private String brandName;
	private LocalDateTime registerdAt;
	private LocalDateTime unregisterdAt;
	private Long partnerId;

}
