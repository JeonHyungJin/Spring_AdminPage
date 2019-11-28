package com.example.demo.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {
	ALL(0, "묶음", "모든 상품을 묶음 발송"),
	EACH(1, "개별", "준비대는 대로 발송");
	
	private Integer id;
	private String title;
	private String description;
}
