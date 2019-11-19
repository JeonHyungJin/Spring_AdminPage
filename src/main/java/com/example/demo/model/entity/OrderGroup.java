package com.example.demo.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = {"user", "orderDetailList"})
@EntityListeners(AuditingEntityListener.class )
public class OrderGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;
	private String orderType;
	private String revAddress;
	private String revName;
	private String paymentType;
	private BigDecimal totalPrice;
	private Integer totalQuantity;
	private LocalDateTime orderAt;
	private LocalDateTime arrivalDate;
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;

	//OrderGroup N : 1 User
	@ManyToOne
	private User user;
	
	//OrderGroup 1 : N OrderDetail
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
	private List<OrderDetail> orderDetailList;
}
