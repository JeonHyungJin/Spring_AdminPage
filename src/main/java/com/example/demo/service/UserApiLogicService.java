package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.entity.User;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.UserApiRequest;
import com.example.demo.model.network.response.UserApiResponse;
import com.example.demo.repository.UserRepository;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

	@Autowired
	private UserRepository userRepository;

	// 1. request data
	// 2. user 생성
	// 3. 생성된 데이터 -> UserApiResponse return
	@Override
	public Header<UserApiResponse> create(Header<UserApiRequest> request) {
		// TODO Auto-generated method stub

		UserApiRequest userApiRequest = request.getData();

		User user = new User().builder().account(userApiRequest.getAccount()).password(userApiRequest.getPassword())
				.status("REGISTERED").phoneNumber(userApiRequest.getPhoneNumber()).email(userApiRequest.getEmail())
				.registeredAt(LocalDateTime.now()).build();

		User newUser = userRepository.save(user);

		return response(newUser);
	}

	@Override
	public Header<UserApiResponse> read(Long id) {
		// TODO Auto-generated method stub

		// id -> repository getOne, getById
		return userRepository.findById(id).map(user -> response(user)).orElseGet(() -> Header.ERROR("데이터 없음"));

		// user-> userApiResponse return

	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {
		// TODO Auto-generated method stub

		// 1.data
		UserApiRequest userApiRequest = request.getData();

		// 2.id -> user data search
		Optional<User> optional = userRepository.findById(userApiRequest.getId());

		return optional.map(user -> {
			// 3.update
			user.setAccount(userApiRequest.getAccount()).setPassword(userApiRequest.getPassword())
					.setStatus(userApiRequest.getStatus())
					.setPhoneNumber(userApiRequest.getPhoneNumber()).setEmail(userApiRequest.getEmail())
					.setRegisteredAt(userApiRequest.getRegisteredAt())
					.setUnregisteredAt(userApiRequest.getUnregisteredAt());

			// 4.userApiResponse
			return user;
		}).map(user -> userRepository.save(user)).map(user -> response(user)).orElseGet(() -> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	private Header<UserApiResponse> response(User user) {
		UserApiResponse userApiResponse = UserApiResponse.builder().id(user.getId()).account(user.getAccount())
				.password(user.getPassword()) // todo 암호화
				.email(user.getEmail()).phoneNumber(user.getPhoneNumber()).status(user.getStatus())
				.registeredAt(user.getRegisteredAt()).unregisteredAt(user.getUnregisteredAt()).build();

		// Header + data return
		return Header.OK(userApiResponse);
	}

}
