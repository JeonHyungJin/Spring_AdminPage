package com.example.demo.model.network.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.model.enumclass.ItemStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemApiRequest {

	private Long id;
	private ItemStatus status;
	private String name;
	private String title;
	private String content;
	private BigDecimal price;
	private String brandName;
	private LocalDateTime registerdAt;
	private LocalDateTime unregisterdAt;
	private Long partnerId;

}
