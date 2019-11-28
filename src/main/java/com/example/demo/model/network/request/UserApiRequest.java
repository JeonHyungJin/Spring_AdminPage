package com.example.demo.model.network.request;

import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.demo.model.enumclass.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiRequest {

	private Long id;
	private String account;
	private String password;
	private UserStatus status;
	private String email;
	private String phoneNumber;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
}
