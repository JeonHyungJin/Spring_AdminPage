package com.example.demo.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {

	// api 통신 시간
	private LocalDateTime transactionTime;
	// api 응답 코드
	private  String resultCode;
	// api 부가 설명
	private String description;
	
	private T data;
	
	
	public static <T> Header<T> OK(){
		return (Header<T>)Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}
	
	public static <T> Header<T> OK(T data){
		return (Header<T>)Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.data(data)
				.build();
	}
	
	public static <T> Header<T> ERROR(String description){
		return (Header<T>)Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("ERROR")
				.description(description)
				.build();
	}
	
}
