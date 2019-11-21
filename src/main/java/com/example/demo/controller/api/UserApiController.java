package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.UserApiRequest;
import com.example.demo.model.network.response.UserApiResponse;
import com.example.demo.service.UserApiLogicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

	@Autowired
	private UserApiLogicService userApiLogicService;

	@Override
	@PostMapping("") // /api/user
	public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
		// TODO Auto-generated method stub
		log.info("{}",request);
		return userApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}") // /api/user/{id}
	public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		log.info("read id : {}",id);
		return userApiLogicService.read(id);
	}

	@Override
	@PutMapping("") // /api/user
	public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
		// TODO Auto-generated method stub
		return userApiLogicService.update(request);
	}

	@Override
	@DeleteMapping("{id}") // api/user/{id}
	public Header delete(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		return userApiLogicService.delete(id);
	}

}
