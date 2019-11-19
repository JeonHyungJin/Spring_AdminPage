package com.example.demo.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderGroup", "item"})
@EntityListeners(AuditingEntityListener.class )
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;
	private LocalDateTime arrivalDate;
	private Integer quantity;
	private BigDecimal totalPrice;
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;
	
	//OrderDetail N : 1 Item
	@ManyToOne
	private Item item;
	
	//OrderDetail N : 1 OrderGroup
	@ManyToOne
	private OrderGroup orderGroup;
}
